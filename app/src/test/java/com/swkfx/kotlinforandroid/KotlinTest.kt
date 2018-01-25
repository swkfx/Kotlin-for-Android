package com.swkfx.kotlinforandroid

import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/24
 *      desc   :
 * </pre>
 */
class KotlinTest {
    @Test
    fun dateTest() {
        //    2015-08-06T04:16:55.575Z
        val millis = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.getDefault())
        println("date-->" + dateFormat.format(millis))

    }
}