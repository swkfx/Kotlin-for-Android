package com.swkfx.kotlinforandroid.data.server

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
data class GirlListResult(val error: Boolean, val results: List<Girl>)

data class Girl(val _id: String,
                val createdAt: String,
                val desc: String,
                val publishedAt: String,
                val source: String,
                val type: String,
                val url: String,
                val used: Boolean,
                val who: String)

