package com.swkfx.kotlinforandroid.domain.commands

import com.swkfx.kotlinforandroid.domain.datasource.GirlsProvider
import com.swkfx.kotlinforandroid.domain.model.GirlListModel

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
class RequestGirlListCommand(private val pageNumber: Int, private val provider: GirlsProvider = GirlsProvider()) : Command<GirlListModel> {

    override fun execute() = provider.requestGirls(pageNumber)
}