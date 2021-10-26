package com.github.crayonxiaoxin.observermode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    lateinit var sayHello: Button
    lateinit var sayYes: Button
    lateinit var sayNo: Button

    lateinit var addToast: Button
    lateinit var removeToast: Button

    /**
     * 观察者的匿名内部实现
     */
    private val textObserver = object : Observer {
        override fun hello(string: String) {
            textView.text = string
        }

        override fun bye(boolean: Boolean) {
            textView.text = if (boolean) "bye" else "stay"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 主题
        val subject = Subject()
        // 注册
        subject.registerObserver(textObserver)
        val toastObserver = ToastObserver()

        textView = findViewById(R.id.textView)
        sayHello = findViewById(R.id.sayHello)
        sayYes = findViewById(R.id.sayYes)
        sayNo = findViewById(R.id.sayNo)
        addToast = findViewById(R.id.addToast)
        removeToast = findViewById(R.id.removeToast)

        // 通知所有订阅者
        sayHello.setOnClickListener {
            subject.hello("hello")
        }
        sayYes.setOnClickListener {
            subject.bye(true)
        }
        sayNo.setOnClickListener {
            subject.bye(false)
        }
        // 订阅与反订阅
        addToast.setOnClickListener {
            subject.registerObserver(toastObserver)
        }
        removeToast.setOnClickListener {
            subject.unregisterObserver(toastObserver)
        }
    }
}