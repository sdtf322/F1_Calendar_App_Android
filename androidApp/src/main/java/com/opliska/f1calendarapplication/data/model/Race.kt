package com.opliska.f1calendarapplication.data.model

import com.google.firebase.database.PropertyName

data class Race(
    val cacheId: Long = ID_NONE,
    @get:PropertyName("Circuit") @set:PropertyName("Circuit") var circuit: Circuit? = null,
    @PropertyName("FirstPractice") val firstPractice: RaceSession? = null,
    @PropertyName("LapRecord") val lapRecord: LapRecord? = null,
    @PropertyName("Qualifying") val qualifying: RaceSession? = null,
    @PropertyName("SecondPractice") val secondPractice: RaceSession? = null,
    @PropertyName("ThirdPractice") val thirdPractice: RaceSession? = null,
    @PropertyName("Sprint") val sprint: RaceSession? = null,
    val date: String? = null,
    val raceName: String? = null,
    val round: String? = null,
    val season: String? = null,
    val time: String? = null,
    val trackLength: Int? = null,
    val url: String? = null,
    val yearStarted: String? = null
) {
    companion object {
        const val ID_NONE: Long = 0L
    }
}