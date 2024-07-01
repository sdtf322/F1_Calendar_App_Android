package com.opliska.f1calendarapplication.data.model

data class Race(
    val circuit: Circuit? = null,
    val firstPractice: FirstPractice? = null,
    val lapRecord: LapRecord? = null,
    val qualifying: Qualifying? = null,
    val secondPractice: SecondPractice? = null,
    val thirdPractice: ThirdPractice? = null,
    val sprint: Sprint? = null,
    val date: String? = null,
    val raceName: String? = null,
    val round: String? = null,
    val season: String? = null,
    val time: String? = null,
    val trackLength: Int? = null,
    val url: String? = null,
    val yearStarted: String? = null
)