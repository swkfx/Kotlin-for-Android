package com.swkfx.kotlinforandroid.data.db

import com.swkfx.kotlinforandroid.domain.datasource.DataSource
import com.swkfx.kotlinforandroid.domain.model.GirlByDayModel
import com.swkfx.kotlinforandroid.domain.model.GirlListModel
import com.swkfx.kotlinforandroid.extensions.clear
import com.swkfx.kotlinforandroid.extensions.parseList
import com.swkfx.kotlinforandroid.extensions.toVarargArray
import org.jetbrains.anko.db.RowParser
import org.jetbrains.anko.db.SqlOrderDirection
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/2
 *      desc   : use  函数返回的结果作为这个函数返回的结果
 * </pre>
 */
class GirlDao(private val dbHelper: DbHelper = DbHelper.instance, private val dbDataMapper: DbDataMapper = DbDataMapper()) : DataSource {
    override fun requestGirlByDay(year: String, month: String, day: String): GirlByDayModel? = dbHelper.use {

        //2018-01-16
        val sql = "${GirlsTable.PUBLISHED_AT} LIKE '$year-$month-$day%' AND ${GirlsTable.TYPE} IS NOT '福利'"
        val girls = select(GirlsTable.NAME)
                .whereArgs(sql)
                .parseList {
                    GirlDb(HashMap(it))
                }
        val queryAll = "${GirlsTable.PUBLISHED_AT} LIKE '$year-$month-$day%'"
        val allGirls = select(GirlsTable.NAME)
                .whereArgs(queryAll)
                .orderBy(GirlsTable.ID, SqlOrderDirection.DESC)
                .parseList {
                    GirlDb(HashMap(it))
                }
        val girl = if (girls.isEmpty()) girls else allGirls
        girl.let { dbDataMapper.convertGirlDayToDomain(it) }
    }

    override fun requestGirls(pageNumber: Int): GirlListModel = requestGirlList(pageNumber)

    private fun requestGirlList(pageCount: Int) = dbHelper.use {
        val pageSize = 10
        val offset = (pageCount - 1) * 10
        //可以直接去 表中的值 取出的 cloumns 是个 array
        val girlList = select(GirlsTable.NAME).limit(offset, pageSize).parseList(object : RowParser<GirlDb> {
            override fun parseRow(columns: Array<Any?>): GirlDb {
                return GirlDb(columns)
            }
        })
        //也可以取 mapRow  取出的是个 map ,key = 字段名, value = 值.
        val girls = select(GirlsTable.NAME)
                .whereArgs("${GirlsTable.TYPE}='福利'")
                .limit(offset, pageSize)
                .parseList {
                    val hashMap = HashMap(it)
                    GirlDb(hashMap)
                }
        girls?.let { dbDataMapper.convertGirlsToDomain(it) }
    }


    fun saveGirlList(girlList: GirlListModel) = dbHelper.use {

        clear(GirlsTable.NAME)

        val receiver = dbDataMapper.convertFromDomain(girlList)
        with(receiver) {
            forEach {
                val insert = insert(GirlsTable.NAME, *it.map.toVarargArray())
                println("insert = $insert")
            }
        }


    }

    fun saveGirlByDay(dayGirl: GirlByDayModel) = dbHelper.use {

        dayGirl.girlMap.values.forEach {
            val receiver = dbDataMapper.convertFromDomain(it)
            with(receiver) {
                forEach {
                    val sql = "${GirlsTable.GIRL_ID} = ?"
                    val girlList = select(GirlsTable.NAME).whereSimple(sql, it.girl_id).parseList {
                        val hashMap = HashMap(it)
                        GirlDb(hashMap)
                    }
                    if (girlList.isEmpty()) {
                        val insert = insert(GirlsTable.NAME, *it.map.toVarargArray())
                        println("insert = $insert")
                    } else {
                        println(" girl_id = ${it.girl_id} is exist")
                    }
                }
            }
        }
    }
}