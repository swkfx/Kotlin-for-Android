package com.swkfx.kotlinforandroid.data.db

import android.database.sqlite.SQLiteDatabase
import com.swkfx.kotlinforandroid.ui.App
import org.jetbrains.anko.db.*

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/12/5
 *      desc   :
 * </pre>
 */
class DbHelper() : ManagedSQLiteOpenHelper(App.instance, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME: String = "girl.db"
        val DB_VERSION: Int = 1
        val instance: DbHelper by lazy {
            DbHelper()
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        createGirlTable(db)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //只是删除表格.如果需要保留还需要再处理.
        db?.dropTable(GirlsTable.NAME)
        onCreate(db)
    }

    private fun createGirlTable(db: SQLiteDatabase?) {
        db?.createTable(GirlsTable.NAME, true,
                GirlsTable.ID to INTEGER + PRIMARY_KEY,
                GirlsTable.GIRL_ID to TEXT + UNIQUE,
                GirlsTable.CREATEAT to TEXT,
                GirlsTable.DESC to TEXT,
                GirlsTable.PUBLISHEDAT to TEXT,
                GirlsTable.SOURCE to TEXT,
                GirlsTable.TYPE to TEXT,
                GirlsTable.URL to TEXT,
                GirlsTable.USED to INTEGER,
                GirlsTable.WHO to TEXT)
    }
}

