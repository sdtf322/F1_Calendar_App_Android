package com.opliska.f1calendarapplication.data

import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.data.model.Race
import com.opliska.f1calendarapplication.presentation.RaceUI
import kotlinx.collections.immutable.toImmutableList

//Todo immutable list error should disappear after a successful build (?)

internal fun RequestResult<List<RaceUI>>.toState(): State {
    return when (this) {
        is RequestResult.Error -> State.Error(data?.toImmutableList())
        is RequestResult.InProgress -> State.Loading(data?.toImmutableList())
        is RequestResult.Success -> State.Success(data.toImmutableList())
    }
}

internal fun Race.toRaceUI(): RaceUI {
    return RaceUI(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
    )
}