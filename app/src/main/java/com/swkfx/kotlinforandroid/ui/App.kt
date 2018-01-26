package com.swkfx.kotlinforandroid.ui

import android.app.Application
import android.os.Environment
import com.swkfx.kotlinforandroid.extensions.DelegatesExt
import java.io.File

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
        copyDb()
    }

    private fun copyDb() {
        val dbFile = File("data/data/com.swkfx.kotlinforandroid/databases/girl.db")
        val copyFile = File(Environment.getExternalStorageDirectory().absolutePath + File.separator + "copyGirl.db")
        if (dbFile.exists()) {
            dbFile.copyTo(copyFile, true)
            println("copy db success :${copyFile.absolutePath}")
        } else {
            println("db not exist")
        }

    }
}