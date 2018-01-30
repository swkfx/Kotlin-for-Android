package com.swkfx.kotlinforandroid.ui.activities

import android.graphics.drawable.Drawable
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.extensions.ctx
import com.swkfx.kotlinforandroid.extensions.slideEnter
import com.swkfx.kotlinforandroid.extensions.slideExit
import com.swkfx.kotlinforandroid.ui.App
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/29
 *      desc   : 接口可以被用来从类中提取出相似行为的通用代码。
 * </pre>
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> {
                    toolbar.ctx.startActivity<SettingActivity>()
                }
                else -> {
                    App.instance.toast("Unknown option")
                }
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createArrowDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    fun createArrowDrawable(): Drawable? = DrawerArrowDrawable(toolbar.ctx).apply {
        progress = 1f
    }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                println("rcy onScrolled dx = $dx ,dy = $dy")
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }


}