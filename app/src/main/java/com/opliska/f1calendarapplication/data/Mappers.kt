package com.opliska.f1calendarapplication.data

import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.data.database.model.CircuitDBO
import com.opliska.f1calendarapplication.data.database.model.LapRecordDBO
import com.opliska.f1calendarapplication.data.database.model.LocationDBO
import com.opliska.f1calendarapplication.data.database.model.RaceDBO
import com.opliska.f1calendarapplication.data.database.model.RaceSessionDBO
import com.opliska.f1calendarapplication.data.model.Circuit
import com.opliska.f1calendarapplication.data.model.RaceSession
import com.opliska.f1calendarapplication.data.model.LapRecord
import com.opliska.f1calendarapplication.data.model.Location
import com.opliska.f1calendarapplication.data.model.Race
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
        firstPractice = this.firstPractice?.toRaceSession(),
        secondPractice = this.secondPractice?.toRaceSession(),
        thirdPractice = this.thirdPractice?.toRaceSession(),
        qualifying = this.qualifying?.toRaceSession(),
        sprint = this.sprint?.toRaceSession(),
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
        location = this.location?.toLocation(),
        circuitId = this.circuitId,
        circuitName = this.circuitName,
        url = this.url
    )
}

fun LocationDBO.toLocation(): Location {
    return Location(
        country = this.country,
        lat = this.lat,
        locality = this.locality,
        long = this.long
    )
}

fun LapRecordDBO.toLapRecord(): LapRecord {
    return LapRecord(
        driver = this.driver,
        time = this.time,
        year = this.year
    )
}

fun RaceSessionDBO.toRaceSession(): RaceSession {
    return RaceSession(
        date = this.date,
        time = this.time
    )
}

internal fun Race.toRaceUI(): RaceUI {
    return RaceUI(
        id = round,
        title = raceName,
        description = date,
        imageUrl = circuit?.location?.country
    )
}

//Race data class to DBO logic

fun Race.toRaceDBO(): RaceDBO {
    return RaceDBO(
        circuit = this.circuit?.toCircuitDBO(),
        firstPractice = this.firstPractice?.toRaceSessionDBO(),
        secondPractice = this.secondPractice?.toRaceSessionDBO(),
        thirdPractice = this.thirdPractice?.toRaceSessionDBO(),
        qualifying = this.qualifying?.toRaceSessionDBO(),
        sprint = this.sprint?.toRaceSessionDBO(),
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
        location = this.location?.toLocationDBO(),
        circuitId = this.circuitId,
        circuitName = this.circuitName,
        url = this.url
    )
}

fun Location.toLocationDBO(): LocationDBO {
    return LocationDBO(
        country = this.country,
        lat = this.lat,
        locality = this.locality,
        long = this.long
    )
}

fun LapRecord.toLapRecordDBO(): LapRecordDBO {
    return LapRecordDBO(
        driver = this.driver,
        time = this.time,
        year = this.year
    )
}

fun RaceSession.toRaceSessionDBO(): RaceSessionDBO {
    return RaceSessionDBO(
        date = this.date,
        time = this.time
    )
}
