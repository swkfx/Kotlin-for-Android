package com.swkfx.kotlinforandroid.domain.model

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
data class GirlListModel(val error: Boolean, val girls: List<Girl>)


data class Girl(val _id: String,
                val createAt: String,
                val desc: String,
                val publishedAt: String,
                val source: String,
                val type: String,
                val url: String,
                val used: Boolean,
                val who: String)