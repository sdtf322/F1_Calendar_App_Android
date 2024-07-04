package com.opliska.f1calendarapplication.data

import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.data.database.model.CircuitDBO
import com.opliska.f1calendarapplication.data.database.model.FirstPracticeDBO
import com.opliska.f1calendarapplication.data.database.model.LapRecordDBO
import com.opliska.f1calendarapplication.data.database.model.QualifyingDBO
import com.opliska.f1calendarapplication.data.database.model.RaceDBO
import com.opliska.f1calendarapplication.data.database.model.SecondPracticeDBO
import com.opliska.f1calendarapplication.data.database.model.SprintDBO
import com.opliska.f1calendarapplication.data.database.model.ThirdPracticeDBO
import com.opliska.f1calendarapplication.data.model.Circuit
import com.opliska.f1calendarapplication.data.model.FirstPractice
import com.opliska.f1calendarapplication.data.model.LapRecord
import com.opliska.f1calendarapplication.data.model.Qualifying
import com.opliska.f1calendarapplication.data.model.Race
import com.opliska.f1calendarapplication.data.model.SecondPractice
import com.opliska.f1calendarapplication.data.model.Sprint
import com.opliska.f1calendarapplication.data.model.ThirdPractice
import com.opliska.f1calendarapplication.presentation.RaceUI
import kotlinx.collections.immutable.toImmutableList

internal fun RequestResult<List<RaceUI>>.toState(): State {
    return when (this) {
        is RequestResult.Error -> State.Error(data?.toImmutableList())
        is RequestResult.InProgress -> State.Loading(data?.toImmutableList())
        is RequestResult.Success -> State.Success(data.toImmutableList())
    }
}

//DBO to Race data class logic

fun RaceDBO.toRace(): Race {
    return Race(
        cacheId = this.id,
        circuit = this.circuit?.toCircuit(),
        firstPractice = this.firstPractice?.toFirstPractice(),
        secondPractice = this.secondPractice?.toSecondPractice(),
        thirdPractice = this.thirdPractice?.toThirdPractice(),
        qualifying = this.qualifying?.toQualifying(),
        sprint = this.sprint?.toSprint(),
        lapRecord = this.lapRecord?.toLapRecord(),
        date = this.date,
        raceName = this.raceName,
        round = this.round,
        season = this.season,
        time = this.time,
        trackLength = this.trackLength,
        url = this.url,
        yearStarted = this.yearStarted
    )
}

fun CircuitDBO.toCircuit(): Circuit {
    return Circuit(
        location = this.location,
        circuitId = this.circuitId,
        circuitName = this.circuitName,
        url = this.url
    )
}

fun LapRecordDBO.toLapRecord(): LapRecord {
    return LapRecord(
        driver = this.driver,
        time = this.time,
        year = this.year
    )
}

fun FirstPracticeDBO.toFirstPractice(): FirstPractice {
    return FirstPractice(
        date = this.date,
        time = this.time
    )
}

fun SecondPracticeDBO.toSecondPractice(): SecondPractice {
    return SecondPractice(
        date = this.date,
        time = this.time
    )
}

fun ThirdPracticeDBO.toThirdPractice(): ThirdPractice {
    return ThirdPractice(
        date = date,
        time = time
    )
}

fun QualifyingDBO.toQualifying(): Qualifying {
    return Qualifying(
        date = this.date,
        time = this.time
    )
}

fun SprintDBO.toSprint(): Sprint {
    return Sprint(
        date = this.date,
        time = this.time
    )
}

internal fun Race.toRaceUI(): RaceUI {
    return RaceUI(
        id = round,
        title = raceName,
        description = date
    )
}


//Race data class to DBO logic

fun Race.toRaceDBO(): RaceDBO {
    return RaceDBO(
        circuit = this.circuit?.toCircuitDBO(),
        firstPractice = this.firstPractice?.toFirstPracticeDBO(),
        secondPractice = this.secondPractice?.toSecondPracticeDBO(),
        thirdPractice = this.thirdPractice?.toThirdPracticeDBO(),
        qualifying = this.qualifying?.toQualifyingDBO(),
        sprint = this.sprint?.toSprintDBO(),
        lapRecord = this.lapRecord?.toLapRecordDBO(),
        date = this.date,
        raceName = this.raceName,
        round = this.round,
        season = this.season,
        time = this.time,
        trackLength = this.trackLength,
        url = this.url,
        yearStarted = this.yearStarted,
        id = this.cacheId
    )
}

fun Circuit.toCircuitDBO(): CircuitDBO {
    return CircuitDBO(
        location = this.location,
        circuitId = this.circuitId,
        circuitName = this.circuitName,
        url = this.url
    )
}

fun LapRecord.toLapRecordDBO(): LapRecordDBO {
    return LapRecordDBO(
        driver = this.driver,
        time = this.time,
        year = this.year
    )
}

fun FirstPractice.toFirstPracticeDBO(): FirstPracticeDBO {
    return FirstPracticeDBO(
        date = this.date,
        time = this.time
    )
}

fun SecondPractice.toSecondPracticeDBO(): SecondPracticeDBO {
    return SecondPracticeDBO(
        date = this.date,
        time = this.time
    )
}

fun ThirdPractice.toThirdPracticeDBO(): ThirdPracticeDBO {
    return ThirdPracticeDBO(
        date = this.date,
        time = this.time
    )
}

fun Qualifying.toQualifyingDBO(): QualifyingDBO {
    return QualifyingDBO(
        date = this.date,
        time = this.time
    )
}

fun Sprint.toSprintDBO(): SprintDBO {
    return SprintDBO(
        date = this.date,
        time = this.time
    )
}
