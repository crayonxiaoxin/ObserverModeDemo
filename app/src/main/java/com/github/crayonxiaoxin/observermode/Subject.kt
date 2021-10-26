package com.github.crayonxiaoxin.observermode

/**
 * 被观察者  （被订阅的主题）
 *
 * @Desc: 实现 Observer 是为了方便通知到每一个方法（这里实际上是省略了主题的抽象类）
 * @Author: Lau
 * @Date: 2021/10/26 11:55 上午
 */
class Subject : Observer {

    var callbacks = ArrayList<Observer?>()

    fun registerObserver(observer: Observer?) {
        if (!callbacks.contains(observer)) {
            callbacks.add(observer)
        }
    }

    fun unregisterObserver(observer: Observer?) {
        if (callbacks.contains(observer)) {
            callbacks.remove(observer)
        }
    }

    override fun hello(string: String) {
        callbacks.forEach {
            it?.hello(string)
        }
    }

    override fun bye(boolean: Boolean) {
        callbacks.forEach {
            it?.bye(boolean)
        }
    }
}