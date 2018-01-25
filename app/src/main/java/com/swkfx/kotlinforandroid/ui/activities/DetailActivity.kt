package com.swkfx.kotlinforandroid.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.domain.commands.RequestGirlByDayCommand
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
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
        val year = calendar.get(Calendar.YEAR).toString()
        val month = (calendar.get(Calendar.MONTH) + 1).toString()
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
        val dateStr = "$year/$month/$day"
        doAsync {
            val girlByDay = RequestGirlByDayCommand(year, month, day).execute()
            if (!girlByDay.error) {
                println("list.size = ${girlByDay.category.size},map.size = ${girlByDay.results.size}")
            }
            uiThread {
                val builder = StringBuilder(dateStr)
                builder.append("\r\n")
                builder.append("\r\n")
                builder.append(girlByDay.category.toString()).append("\r\n").append("\r\n")
                for ((key, value) in girlByDay.results) {
                    builder.append("\t====$key====").append("\r\n").append("\r\n")
                    value.forEach {
                        builder.append("\t\t- ${it.desc}").append("\r\n")

                        if (value.size - 1 == value.indexOf(it)) {
                            builder.append("\r\n")
                        }
                    }
                }

                tvDesc.text = builder.toString()
            }
        }
    }
}
