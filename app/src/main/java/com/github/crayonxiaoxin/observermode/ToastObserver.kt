package com.github.crayonxiaoxin.observermode

import android.widget.Toast

/**
 * 观察者的一个实现
 *
 * @Desc:
 * @Author: Lau
 * @Date: 2021/10/26 11:59 上午
 */
class ToastObserver:Observer {
    override fun hello(string: String) {
        Toast.makeText(App.appContext, "ToastObserver: $string", Toast.LENGTH_SHORT).show()
    }

    override fun bye(boolean: Boolean) {
        Toast.makeText(App.appContext, "ToastObserver: $boolean", Toast.LENGTH_SHORT).show()
    }
}