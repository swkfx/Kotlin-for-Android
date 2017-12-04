package com.swkfx.kotlinforandroid.domain.datasource

import android.util.Log
import com.google.gson.Gson
import com.swkfx.kotlinforandroid.data.server.GirlListResult
import java.net.URL
import java.net.URLEncoder

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */

class GirlListRequest(private val pageCount: Int) {

    companion object {
        private val TYPE = "福利"
        private val PAGE_SIZE = "10"
    }


    fun execute(): GirlListResult {
        val type = URLEncoder.encode(TYPE, "utf-8")
        val url = "http://gank.io/api/data/$type/$PAGE_SIZE/$pageCount"
//        val completeUrl: String = url + pageCount
        Log.d("GirlListRequest", url)
        val jsonStr = URL(url).readText()
        Log.d("GirlListRequest", jsonStr)
        return Gson().fromJson(jsonStr, GirlListResult::class.java)
    }

}