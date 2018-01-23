package com.swkfx.kotlinforandroid

import org.junit.Test
import java.util.*

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/22
 *      desc   :
 * </pre>
 */
class FlowControlAndRangesTest {

    @Test
    fun testIf() {
        /*
        * 这样写没错 但是很丑.阅读性很差.尽量只在 if else 这样写来代替三元操作符.
        * */
        val x: Int = Random().nextInt(10) + -5
        val y: Int = if (x > 0) {
            toast("x is greater than 0")
            1
        } else if (x == 0) {
            toast("x equals 0")
            0
        } else {
            toast("x is smaller than 0")
            -1
        }
        toast("y = $y")
    }


    @Test
    fun testWhen() {
        val x = Random().nextInt(10) + -5 //这样不用写括号,用空格分开.
        when (x) {
            1, 2, 3, 4, 5 -> { //也可以 用 in 1..5 这样的表达式
                toast("x > 0")
            }
            0 -> {
                toast("x == 0")
            }
            else -> {
                toast("x < 0")
            }
        }
        //两种写法.如果当成参数貌似只能罗列出所有结果.
        //如果没有参数的形式.可以直接写表达式.感觉这样灵活点.
        when {
            x > 0 -> {
                toast("x is greater than 0")
            }
            x == 0 -> {
                toast("x equals 0")
            }
            else -> {
                toast("x is smaller than 0")
            }
        }

        toast("testWhen x = $x")
    }


    @Test
    fun testFor() {
        for (i in 1..5) {
            toast("testFor i = $i")
        }
        val list = arrayListOf(5, 6, 7, 8, 9, 10)
        for (l in list) {
            println("testFor l = $l")
        }

        for (i in list.indices) {
            println("index = $i,value = " + list[i])
        }

    }


    @Test
    fun testWhile() {
        var x = 10
        while (x > 5) {
            x--
            println("testWhile x = $x")
        }

        var y = 5
        do {
            y--
            println("testWhile y = $y")
        } while (y >= 0)

        //do while 逻辑写在do中. 至少执行一次.不要在do中重新赋值.不然就死循环了.
    }

    @Test
    fun testRanges() {

        val x = 8
        if (x in 10 downTo 0) {
            println("testRanges true")
        }

        //step
        for (i in 1..10 step 3) {
            //            println("testRanges i = $i")
        }
        for (i in 10 downTo 1 step 3) {
            println("testRanges i = $i")
        }

        //until 不包含最后一项
        for (i in 1 until 10) {
            println("testRanges until i=$i")
        }

        //Ranges  默认会自增长 如果 不是自增长区间会什么都不做 如 i in 10..0 也不会报错.
        for (i in 10..5) {
            println("error-- i $i")
        }
    }

    private fun toast(string: Any?) = println(string)
}