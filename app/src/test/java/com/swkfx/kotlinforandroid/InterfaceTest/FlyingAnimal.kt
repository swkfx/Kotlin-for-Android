package com.swkfx.kotlinforandroid.InterfaceTest

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/29
 *      desc   :
 * </pre>
 */
interface FlyingAnimal {
    val wings: Wings
    fun fly() = wings.move()
}