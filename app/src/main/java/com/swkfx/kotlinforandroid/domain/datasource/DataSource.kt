package com.swkfx.kotlinforandroid.domain.datasource

import com.swkfx.kotlinforandroid.data.server.GirlByDay
import com.swkfx.kotlinforandroid.domain.model.GirlByDayModel
import com.swkfx.kotlinforandroid.domain.model.GirlListModel

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/9
 *      desc   :
 * </pre>
 */
interface DataSource {
    fun requestGirls(pageNumber: Int): GirlListModel

    fun requestGirlByDay(year: String, month: String, day: String): GirlByDayModel
}