package com.swkfx.kotlinforandroid.data.server

import org.junit.Assert.assertEquals

/**
 * Created by SwkFx on 2018/1/25.
 */
class GirlByDayRequestTest {
    fun execute() {
        val result = GirlByDayRequest("2015", "08", "07").execute()
        assertEquals(false, result.error)

    }

}