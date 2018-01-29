package com.swkfx.kotlinforandroid.InterfaceTest

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/29
 *      desc   :
 * </pre>
 */
class Bird : FlyingAnimal {
    override val wings: Wings = Wings()
}

class Bat : FlyingAnimal {
    override val wings: Wings
        get() = Wings()

}