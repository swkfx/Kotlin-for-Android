package com.swkfx.kotlinforandroid.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.domain.commands.RequestGirlByDayCommand
import com.swkfx.kotlinforandroid.extensions.dataToString
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import java.util.*

class DetailActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }
    companion object {
        val KEY_DATE = "DetailActivity:date"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initToolbar()
        enableHomeAsUp { onBackPressed() }
        val date: Date = intent.getSerializableExtra(KEY_DATE) as Date
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar.get(Calendar.YEAR).toString()
        val month = (calendar.get(Calendar.MONTH) + 1).dataToString()
        val day = calendar.get(Calendar.DAY_OF_MONTH).dataToString()
        val dateStr = "$year/$month/$day"
        toolbarTitle = dateStr
        doAsync {
            val girlByDay = RequestGirlByDayCommand(year, month, day).execute()
            if (!girlByDay.error) {
                println("list.size = ${girlByDay.category.size},map.size = ${girlByDay.girlMap.size}")
            }
            uiThread {
                val builder = StringBuilder()
                builder.append(girlByDay.category.toString()).append("\r\n").append("\r\n")
                for ((key, value) in girlByDay.girlMap) {
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
