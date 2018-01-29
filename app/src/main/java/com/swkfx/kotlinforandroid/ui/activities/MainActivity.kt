package com.swkfx.kotlinforandroid.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.domain.commands.RequestGirlListCommand
import com.swkfx.kotlinforandroid.domain.model.Girl
import com.swkfx.kotlinforandroid.extensions.formatDate
import com.swkfx.kotlinforandroid.ui.adapters.GirlAdapter
import com.swkfx.kotlinforandroid.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : BaseActivity(), ToolbarManager {

    private val items = listOf("meiziOne", "meiziTwo", "meiziThree")
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        setUpList()
        attachToScroll(girlList)
        toolbarTitle = "Gank-Girl"
    }


    /*设置列表*/
    private fun setUpList() {
//        val girlList = find<RecyclerView>(R.id.girl_list)
        girlList.layoutManager = LinearLayoutManager(this@MainActivity)
        girlList.setHasFixedSize(true)
        doAsync {
            val girlListModel = RequestGirlListCommand(1).execute()
            uiThread {
                if (!girlListModel.error) {
                    val girlAdapter = GirlAdapter(girlListModel.girls) { girl: Girl, positon: Int ->
                        //                        toast("girl._id${girl._id},pos$positon")
                        val publishedAt = girl.publishedAt
                        startActivity<DetailActivity>(DetailActivity.KEY_DATE to publishedAt.formatDate())
                    }

                    //Lambdas
                    //简化
//                    girlAdapter.setItemClickListener { girl, position -> toast("click pos : " + position) }
                    //不简化
//                    girlAdapter.setItemClickListener { girl: Girl, i: Int ->
//                        object : GirlAdapter.OnItemClickListener {
//                            override fun invoke(girl: Girl, position: Int) {
//                                toast("click pos : " + i)
//                            }
//
//                        }
//                    }

                    //最后采用Java的方式继续~~
                    //                    girlAdapter.setItemClickListener(object : GirlAdapter.OnItemClickListener {
                    //                        override fun invoke(girl: Girl, position: Int) {
                    //                            toast("click item position -> " + position)
                    //                        }
                    //                    })

                    girlList.adapter = girlAdapter
                } else {
                    longToast("request girl list fail")
                }
            }
        }

    }
}
