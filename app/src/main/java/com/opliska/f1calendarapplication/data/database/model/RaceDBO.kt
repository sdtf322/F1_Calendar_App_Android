package com.opliska.f1calendarapplication.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.opliska.f1calendarapplication.data.model.Location

@Entity(tableName = "races")
data class RaceDBO(
    @Embedded(prefix = "circuit") val circuit: CircuitDBO?,
    @Embedded(prefix = "first_practice") val firstPractice: FirstPracticeDBO?,
    @Embedded(prefix = "second_practice") val secondPractice: SecondPracticeDBO?,
    @Embedded(prefix = "third_practice") val thirdPractice: ThirdPracticeDBO?,
    @Embedded(prefix = "qualifying") val qualifying: QualifyingDBO?,
    @Embedded(prefix = "sprint") val sprint: SprintDBO?,
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
    val location: Location? = null,
    val circuitId: String? = null,
    val circuitName: String? = null,
    val url: String? = null
)

data class LapRecordDBO(
    val driver: String? = null,
    val time: String? = null,
    val year: String? = null
)

data class FirstPracticeDBO(
    val date: String? = null,
    val time: String? = null
)

data class SecondPracticeDBO(
    val date: String? = null,
    val time: String? = null
)

data class ThirdPracticeDBO(
    val date: String? = null,
    val time: String? = null
)

data class QualifyingDBO(
    val date: String? = null,
    val time: String? = null
)

data class SprintDBO(
    val date: String? = null,
    val time: String? = null
)