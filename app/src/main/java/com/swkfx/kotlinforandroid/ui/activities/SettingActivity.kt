package com.swkfx.kotlinforandroid.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.swkfx.kotlinforandroid.R
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class SettingActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar: Toolbar
        get() = find(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        toolbarTitle = "设置"
        enableHomeAsUp { onBackPressed() }

        tv_version_text.setOnClickListener { toast("当前版本号:v1.0 已经是最新版本") }
    }
}
