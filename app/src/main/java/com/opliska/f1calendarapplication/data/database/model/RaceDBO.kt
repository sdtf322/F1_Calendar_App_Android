package com.opliska.f1calendarapplication.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "races")
data class RaceDBO(
    @Embedded(prefix = "circuit") val circuit: CircuitDBO?,
    @Embedded(prefix = "first_practice") val firstPractice: RaceSessionDBO?,
    @Embedded(prefix = "second_practice") val secondPractice: RaceSessionDBO?,
    @Embedded(prefix = "third_practice") val thirdPractice: RaceSessionDBO?,
    @Embedded(prefix = "qualifying") val qualifying: RaceSessionDBO?,
    @Embedded(prefix = "sprint") val sprint: RaceSessionDBO?,
    @Embedded(prefix = "lap_record") val lapRecord: LapRecordDBO?,
    @ColumnInfo("date") val date: String?,
    @ColumnInfo("race_name") val raceName: String?,
    @ColumnInfo("round") val round: String?,
    @ColumnInfo("season") val season: String?,
    @ColumnInfo("time") val time: String?,
    @ColumnInfo("trackLength") val trackLength: Int?,
    @ColumnInfo("url") val url: String?,
    @ColumnInfo("yearStarted") val yearStarted: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)

data class CircuitDBO(
    @Embedded(prefix = "location") val location: LocationDBO? = null,
    val circuitId: String? = null,
    val circuitName: String? = null,
    val url: String? = null
)

data class LocationDBO(
    val country: String? = null,
    val lat: String? = null,
    val locality: String? = null,
    val long: String? = null
)

data class LapRecordDBO(
    val driver: String? = null,
    val time: String? = null,
    val year: String? = null
)

data class RaceSessionDBO(
    val date: String? = null,
    val time: String? = null
)