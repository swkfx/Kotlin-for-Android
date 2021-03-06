package com.swkfx.kotlinforandroid.ui.base

import android.content.Context
import android.support.v4.app.Fragment
import org.jetbrains.anko.toast

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/29
 *      desc   : BaseFragment
 * </pre>
 */
open class BaseFragment : Fragment() {

    var mContext: Context? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
        mContext?.toast("223213")
    }



}