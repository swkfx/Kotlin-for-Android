package com.swkfx.kotlin_for_android.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.swkfx.kotlin_for_android.R
import com.swkfx.kotlin_for_android.ui.adapters.GirlAdapter
import com.swkfx.kotlin_for_android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val items = listOf("meiziOne", "meiziTwo", "meiziThree")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        girl_list.layoutManager = LinearLayoutManager(this@MainActivity)
        girl_list.setHasFixedSize(true)
        girl_list.adapter = GirlAdapter(items)
    }
}
