package com.swkfx.kotlinforandroid.data

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.net.URL

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
class Request(private val url: String) : AnkoLogger {
    fun run() {
        val jsonStr = URL(url).readText()
        info(jsonStr)
    }
}