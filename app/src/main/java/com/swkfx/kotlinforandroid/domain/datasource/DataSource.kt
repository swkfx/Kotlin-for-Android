package com.swkfx.kotlinforandroid.domain.datasource

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
}