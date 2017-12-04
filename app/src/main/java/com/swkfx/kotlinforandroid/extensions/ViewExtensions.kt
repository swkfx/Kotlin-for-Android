package com.swkfx.kotlinforandroid.extensions

import android.content.Context
import android.view.View

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/12/4
 *      desc   :
 * </pre>
 */
/* 为View增加扩展变量 context*/
val View.ctx: Context
    get() = context