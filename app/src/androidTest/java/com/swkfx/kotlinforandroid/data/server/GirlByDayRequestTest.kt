package com.swkfx.kotlinforandroid.data.server

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by SwkFx on 2018/1/25.
 */
class GirlByDayRequestTest {
    @Test
    fun execute() {
        val result = GirlByDayRequest("2015", "08", "07").execute()
        assertEquals(false, result.error)

    }

}