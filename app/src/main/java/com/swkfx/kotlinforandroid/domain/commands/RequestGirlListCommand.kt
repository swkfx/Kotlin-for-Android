package com.swkfx.kotlinforandroid.domain.commands

import com.swkfx.kotlinforandroid.domain.datasource.GirlListDataMapper
import com.swkfx.kotlinforandroid.domain.datasource.GirlListRequest
import com.swkfx.kotlinforandroid.domain.model.GirlListModel

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
class RequestGirlListCommand(val pageCount: Int) : Command<GirlListModel> {


    override fun execute(): GirlListModel {
        val rsp = GirlListRequest(pageCount).execute()
        return GirlListDataMapper().convertFromDataModel(rsp)
    }
}