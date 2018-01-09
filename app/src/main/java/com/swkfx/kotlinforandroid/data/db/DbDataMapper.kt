package com.swkfx.kotlinforandroid.data.db

import com.swkfx.kotlinforandroid.domain.model.Girl
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

    private fun convertGirlFromDomain(it: Girl) = with(it) {
        GirlDb(_id, createAt, desc, publishedAt, source, type, url, used, who)
    }

    fun convertGirlsToDomain(girlDbList: List<GirlDb>) = with(girlDbList) {
        GirlListModel(false, girlDbList.map { convertGirlToDomain(it) })
    }

    private fun convertGirlToDomain(it: GirlDb) = with(it) {
        Girl(girl_id, createAt, desc, publishedAt, source, type, url, used, who)
    }

}