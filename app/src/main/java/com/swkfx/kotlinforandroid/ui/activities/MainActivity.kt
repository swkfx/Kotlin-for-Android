package com.swkfx.kotlinforandroid.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.domain.commands.RequestGirlListCommand
import com.swkfx.kotlinforandroid.ui.adapters.GirlAdapter
import com.swkfx.kotlinforandroid.ui.base.BaseActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {

    private val items = listOf("meiziOne", "meiziTwo", "meiziThree")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpList()
    }


    /*设置列表*/
    private fun setUpList() {
        val girlList = find<RecyclerView>(R.id.girl_list)
        girlList.layoutManager = LinearLayoutManager(this@MainActivity)
        girlList.setHasFixedSize(true)
        doAsync {
            val girlListModel = RequestGirlListCommand(1).execute()
            uiThread {
                if (!girlListModel.error) {
                    girlList.adapter = GirlAdapter(girlListModel.girls)
                } else {
                    longToast("request girl list fail")
                }
            }
        }

    }
}
