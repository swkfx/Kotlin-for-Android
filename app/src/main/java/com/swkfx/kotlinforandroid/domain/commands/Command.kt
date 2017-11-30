package com.swkfx.kotlinforandroid.domain.commands

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
/*泛型前的out 不懂*/
interface Command<out T> {
    fun execute(): T
}