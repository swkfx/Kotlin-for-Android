package com.swkfx.kotlinforandroid.domain.datasource

import com.swkfx.kotlinforandroid.data.server.Girl
import com.swkfx.kotlinforandroid.data.server.GirlListResult
import com.swkfx.kotlinforandroid.domain.model.GirlListModel
import com.swkfx.kotlinforandroid.domain.model.Girl as GirlModel

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/30
 *      desc   :
 * </pre>
 */
class GirlListDataMapper {
    fun convertFromDataModel(girlListResult: GirlListResult): GirlListModel {
        return if (!girlListResult.error) {
            GirlListModel(girlListResult.error, convertResultListToDomain(girlListResult.results))
        } else {
            GirlListModel(true, emptyList())
        }
    }

    private fun convertResultListToDomain(result: List<Girl>): List<GirlModel> {
        return result.map {
            convertResultToDomain(it)
        }
    }

    private fun convertResultToDomain(it: Girl): GirlModel {
        return GirlModel(it._id,
                it.createdAt,
                it.desc,
                it.publishedAt,
                it.source,
                it.type,
                it.url,
                it.used,
                it.who)
    }
}