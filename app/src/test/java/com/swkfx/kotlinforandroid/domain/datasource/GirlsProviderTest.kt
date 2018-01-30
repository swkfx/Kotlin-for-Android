package com.swkfx.kotlinforandroid.domain.datasource

import com.swkfx.kotlinforandroid.domain.model.Girl
import com.swkfx.kotlinforandroid.domain.model.GirlByDayModel
import com.swkfx.kotlinforandroid.domain.model.GirlListModel
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * <pre>
 * author : test
 * e-mail : fangx@hyxt.com
 * time   : 2018/1/30
 * desc   :
</pre> *
 */
class GirlsProviderTest {
    @Test
    fun testProvider() {
        val ds = Mockito.mock(DataSource::class.java)
        `when`(ds.requestGirls(ArgumentMatchers.anyInt())).then {
            GirlListModel(false, listOf(Girl("dkkd", "jdjd", "dkkd", "kdkfa", "dkdk", "kdkd", "jdj", 1111, "dfkk")))
        }

        val provider = GirlsProvider(listOf(ds))
        Assert.assertNotNull(provider.requestGirls(0))
        Assert.assertEquals("dkkd", provider.requestGirls(1).girls[0]._id)
    }


    @Test
    fun emptyDatabaseReturnValue() {
        val db = mock(DataSource::class.java)
        val server = mock(DataSource::class.java)
        `when`(server.requestGirlByDay("2018", "01", "30")).then {
            GirlByDayModel(false,
                    listOf("Android"),
                    mapOf("Android" to listOf(Girl("dkkd", "jdjd",
                            "dkkd", "kdkfa", "dkdk",
                            "kdkd", "jdj", 1111, "dfkk"))))
        }
        val provider = GirlsProvider(listOf(db, server))
        Assert.assertNotNull(provider.requestGirlByDay("2018", "01", "30"))
        Assert.assertEquals("dkkd", provider.requestGirlByDay("2018", "01", "30").girlMap["Android"]?.get(0)?._id)

    }
}