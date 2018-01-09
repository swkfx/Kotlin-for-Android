package com.swkfx.kotlinforandroid.data.server

import com.swkfx.kotlinforandroid.data.db.GirlDao
import com.swkfx.kotlinforandroid.domain.datasource.DataSource
import com.swkfx.kotlinforandroid.domain.model.GirlListModel

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/9
 *      desc   :
 * </pre>
 */
class GirlsServer(val girlDao: GirlDao = GirlDao(), val dataMapper: GirlListDataMapper = GirlListDataMapper()) : DataSource {

    override fun requestGirls(pageNumber: Int): GirlListModel {
        val result = GirlListRequest(pageNumber).execute()
        val girlListModel = dataMapper.convertDataToModel(result)
        if (!girlListModel.error) {
            girlDao.saveGirlList(girlListModel)
        }
        return girlListModel
    }
}