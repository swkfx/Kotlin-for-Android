package com.swkfx.kotlinforandroid.data.db

import com.swkfx.kotlinforandroid.domain.model.Girl
import com.swkfx.kotlinforandroid.domain.model.GirlByDayModel
import com.swkfx.kotlinforandroid.domain.model.GirlListModel

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/2
 *      desc   :
 * </pre>
 */
class DbDataMapper {

    fun convertFromDomain(girlList: GirlListModel) = with(girlList) {

        if (!error) {
            girls.map { convertGirlFromDomain(it) }
        } else {
            arrayListOf()
        }

    }

    fun convertFromDomain(girlList: List<Girl>) = with(girlList) {
        girlList.map { convertGirlFromDomain(it) }
    }

    private fun convertGirlFromDomain(it: Girl) = with(it) {
        GirlDb(_id, createAt, desc, publishedAt, source, type, url, used, who)
    }

    fun convertGirlsToDomain(girlDbList: List<GirlDb>) = with(girlDbList) {
        GirlListModel(false, girlDbList.map { convertGirlToDomain(it) })
    }

    private fun convertGirlToDomain(it: GirlDb) = with(it) {
        Girl(girl_id, createAt, desc, publishedAt, source, type, url, used, who)
    }

    fun convertGirlDayToDomain(it: List<GirlDb>): GirlByDayModel {
        val girlMap = HashMap<String, MutableList<Girl>>()
        val category = arrayListOf<String>()
        it.forEach {
            if (girlMap[it.type] == null) {
                girlMap[it.type] = ArrayList()
                category.add(it.type)
            }
            girlMap[it.type]!!.add(convertGirlToDomain(it))
        }
        return if (girlMap.isNotEmpty()) {
            GirlByDayModel(false, category, girlMap)
        } else {
            GirlByDayModel()
        }
    }

}