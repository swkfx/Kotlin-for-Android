package com.swkfx.kotlin_for_android

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.swkfx.kotlinforandroid.data.server.Request
import org.jetbrains.anko.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : AnkoLogger {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.swkfx.kotlin_for_android", appContext.packageName)
    }

    /*仅作展示,以后来看查看当初写的代码用.实际无法运行测试*/
    @Test
    fun kotlinTest() {
//        request()
//        testMapEach()
//        aboutExtensionMethod()
    }

    private fun request() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val url = "http://gank.io/api/data/Android/10/1"
        doAsync {
            Request(url).run()
            uiThread {
                appContext.toast("request performed ~ ~")
            }
        }
    }

    private fun testMapEach() {
        val map = mapOf(Pair(1, "a"), Pair(2, "b"), Pair(3, "c"))
        for ((key, value) in map) {
            info("key=$key,value=$value")
        }
    }

    private fun aboutExtensionMethod() {
        /*
        * 关于扩展函数的发现:
        * 1. 扩展函数不存在多态.及调用有子类的父类的扩展函数不会执行子类的函数
        * 2. 在同一个类中使用 同名(同参)的扩展函数,可以通过调用的对象决定具体调用哪个.意思有点同1点.不存在复写多态.
        * 3. 百度查询的 结论语 是 扩展函数是一种静态分析函数.不是虚函数
        * */
        val text = "anko toast test !!!" as CharSequence
        val context = this as Context
        context.toast(text)
        this.toast("self toast test !!!")
    }
}
