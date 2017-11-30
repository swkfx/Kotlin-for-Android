package com.swkfx.kotlinforandroid.ui.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/29
 *      desc   : BaseActivity
 * </pre>
 */
open class BaseActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        info("onCreate")
    }

    fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }


}