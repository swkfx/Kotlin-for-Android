package com.swkfx.kotlinforandroid.extensions

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/12/5
 *      desc   :
 * </pre>
 */
object Singleton {

    private var name: String = ""

    fun setUserName(name: String) {
        this.name = name
    }

    fun getUserName(): String = this.name
}