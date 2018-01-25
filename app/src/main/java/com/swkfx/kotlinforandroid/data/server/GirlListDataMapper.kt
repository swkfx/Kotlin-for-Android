package com.swkfx.kotlinforandroid.data.server

import com.swkfx.kotlinforandroid.domain.model.GirlByDayModel
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

    fun convertDataToModel(girlListResult: GirlListResult): GirlListModel {
        return if (!girlListResult.error) {
            GirlListModel(girlListResult.error, convertResultListToDomain(girlListResult.results))
        } else {
            GirlListModel(true, emptyList())
        }
    }

    fun convertDayGirlToModel(girlByDay: GirlByDay): GirlByDayModel {
        return if (!girlByDay.error) {
            val girlMap = girlByDay.results
            GirlByDayModel(girlByDay.error, girlByDay.category, convertGirlMapToModel(girlMap))
        } else {
            GirlByDayModel()
        }
    }

    private fun convertGirlMapToModel(girlMap: Map<String, List<Girl>>): Map<String, List<GirlModel>> {
        return girlMap.mapValues { convertResultListToDomain(it.value) }
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
                if (it.used) 0 else 1,
                it.who)
    }
}