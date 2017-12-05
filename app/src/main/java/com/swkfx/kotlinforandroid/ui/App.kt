package com.swkfx.kotlinforandroid.ui

import android.app.Application
import com.swkfx.kotlinforandroid.extensions.DelegatesExt

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/12/5
 *      desc   :
 * </pre>
 */
class App : Application() {


    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}