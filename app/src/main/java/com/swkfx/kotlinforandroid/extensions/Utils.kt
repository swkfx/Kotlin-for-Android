package com.swkfx.kotlinforandroid.extensions

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
fun String.formatDate(): Date {
    //    2015-08-06T04:16:55.575Z
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.zzzZ", Locale.getDefault())
    return dateFormat.parse(this)
}