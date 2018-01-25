package com.swkfx.kotlinforandroid.data.server

import android.util.Log
import com.google.gson.Gson
import java.net.URL
import java.net.URLEncoder

/**
 * <pre>
 *      author : fangx
 *      e-mail : swkfx@163.com
 *      time   : 2018/1/9
 *      desc   :
 * </pre>
 */
class GirlByDayRequest(private val year: String, private val month: String, private val day: String) {


    fun execute(): GirlByDay {
        return try {
            val url = "http://gank.io/api/day/$year/$month/$day"
            //        val completeUrl: String = url + pageNumber
            Log.d("GirlListRequest", url)
            val jsonStr = URL(url).readText()
            Log.d("GirlListRequest", jsonStr)
            Gson().fromJson(jsonStr, GirlByDay::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            GirlByDay()
        }
    }
}