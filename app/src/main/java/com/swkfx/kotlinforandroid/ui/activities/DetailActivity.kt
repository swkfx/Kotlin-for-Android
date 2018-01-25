package com.swkfx.kotlinforandroid.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.swkfx.kotlinforandroid.R
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val KEY_DATE = "DetailActivity:date"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val date: Date = intent.getSerializableExtra(KEY_DATE) as Date
        val calendar = Calendar.getInstance()
        calendar.time = date
        val dateStr: String = calendar.get(Calendar.YEAR).toString() + "/" + calendar.get(Calendar.MONTH).toString() + "/" + calendar.get(Calendar.DAY_OF_MONTH)
        tvDesc.text = dateStr
    }
}
