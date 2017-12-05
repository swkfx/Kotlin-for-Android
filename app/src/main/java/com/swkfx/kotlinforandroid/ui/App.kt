package com.swkfx.kotlinforandroid.ui

import android.app.Application
import android.content.Context
import com.swkfx.kotlinforandroid.extensions.Singleton

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/12/5
 *      desc   :
 * </pre>
 */
class App : Application() {


    val ctx: Context by lazy {
        instance().applicationContext
    }

    companion object {
        private var instance: App? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        Singleton.setUserName("testUserName")
    }
}