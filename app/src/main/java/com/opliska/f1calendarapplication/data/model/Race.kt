package com.opliska.f1calendarapplication.data.model

import com.google.firebase.database.PropertyName

data class Race(
    val cacheId: Long = ID_NONE,
    @PropertyName("Сircuit") val circuit: Circuit? = null,
    val firstPractice: FirstPractice? = null,
    @PropertyName("LapRecord") val lapRecord: LapRecord? = null,
    @PropertyName("Qualifying") val qualifying: Qualifying? = null,
    @PropertyName("SecondPractice") val secondPractice: SecondPractice? = null,
    @PropertyName("ThirdPractice") val thirdPractice: ThirdPractice? = null,
    @PropertyName("Sprint") val sprint: Sprint? = null,
    @PropertyName("date") val date: String? = null,
    @PropertyName("raceName") val raceName: String? = null,
    @PropertyName("round") val round: String? = null,
    @PropertyName("season") val season: String? = null,
    @PropertyName("time") val time: String? = null,
    @PropertyName("trackLength") val trackLength: Int? = null,
    @PropertyName("url") val url: String? = null,
    @PropertyName("yearStarted") val yearStarted: String? = null
) {
    companion object {
        const val ID_NONE: Long = 0L
    }
}