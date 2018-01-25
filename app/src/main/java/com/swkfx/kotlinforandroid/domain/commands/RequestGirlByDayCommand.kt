package com.swkfx.kotlinforandroid.domain.commands

import com.swkfx.kotlinforandroid.data.server.GirlByDay
import com.swkfx.kotlinforandroid.domain.datasource.GirlsProvider

/**
 * Created by SwkFx on 2018/1/25.
 */
class RequestGirlByDayCommand(private val year: String, private val month: String,
                              private val day: String, private val provider:
                              GirlsProvider = GirlsProvider()) : Command<GirlByDay> {
    override fun execute() = provider.requestGirlByDay(year, month, day)
}