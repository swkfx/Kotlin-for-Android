package com.swkfx.kotlinforandroid.extensions

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/3
 *      desc   :
 * </pre>
 */

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete from $tableName")
}

fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })