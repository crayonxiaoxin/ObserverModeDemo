package com.github.crayonxiaoxin.observermode

/**
 * 观察者  订阅者的抽象 及 主题 {@link Subject} 的抽象
 *
 * @Desc:
 * @Author: Lau
 * @Date: 2021/10/26 11:57 上午
 */
interface Observer {
    fun hello(string: String)
    fun bye(boolean: Boolean)
}