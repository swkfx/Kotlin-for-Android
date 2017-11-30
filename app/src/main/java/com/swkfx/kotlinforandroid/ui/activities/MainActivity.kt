package com.swkfx.kotlinforandroid.ui.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.data.Request
import com.swkfx.kotlinforandroid.ui.adapters.GirlAdapter
import com.swkfx.kotlinforandroid.ui.base.BaseActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {

    private val items = listOf("meiziOne", "meiziTwo", "meiziThree")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpList()
        //aboutExtensionMethod()
        request()
    }

    private fun request() {
        val url = "http://gank.io/api/data/Android/10/1"
        doAsync {
            Request(url).run()
            uiThread {
                toast("request performed ~ ~")
            }
        }
    }

    private fun setUpList() {
        val girlList = find<RecyclerView>(R.id.girl_list)
        girlList.layoutManager = LinearLayoutManager(this@MainActivity)
        girlList.setHasFixedSize(true)
        girlList.adapter = GirlAdapter(items)

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
