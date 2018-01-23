package com.swkfx.kotlinforandroid.domain.datasource

import com.swkfx.kotlinforandroid.data.db.GirlDao
import com.swkfx.kotlinforandroid.data.server.GirlsServer
import com.swkfx.kotlinforandroid.domain.model.GirlListModel
import com.swkfx.kotlinforandroid.extensions.firstResult

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/9
 *      desc   :
 * </pre>
 */
class GirlsProvider(val sources: List<DataSource> = GirlsProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(GirlDao(), GirlsServer()) }
    }


    fun requestGirls(pageNumber: Int): GirlListModel = requestToSources {
        val requestGirls = it.requestGirls(pageNumber)
        if (requestGirls.size() > 0) requestGirls else null
    }

    private fun <T : Any> requestToSources(source: (DataSource) -> T?): T = sources.firstResult { source(it) }
}

