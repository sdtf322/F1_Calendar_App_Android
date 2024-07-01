package com.opliska.f1calendarapplication.data

import com.opliska.f1calendarapplication.data.model.Race
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RaceRepository @Inject constructor() {

    fun getAll(): Flow<RequestResult<List<Race>>> {
        val mockData = listOf(
            Race(
                round = "1",
                raceName = "Canadian Grand Prix",
                date = "25-27 MARCH"),
            Race(
                round = "2",
                raceName = "Australian Grand Prix",
                date = "14-16 APRIL"),
            Race(
                round = "3",
                raceName = "Estonian Grand Prix",
                date = "16-18 JUNE"),
        )
        return flowOf(RequestResult.Success(mockData))
    }
}