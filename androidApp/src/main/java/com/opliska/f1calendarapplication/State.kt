package com.opliska.f1calendarapplication

import com.opliska.f1calendarapplication.presentation.RaceUI

import kotlinx.collections.immutable.ImmutableList

sealed class State(open val races: ImmutableList<RaceUI>?) {

    data object None : State(races = null)

    class Loading(races: ImmutableList<RaceUI>? = null) : State(races)

    class Error(races: ImmutableList<RaceUI>? = null) : State(races)

    class Success(override val races: ImmutableList<RaceUI>) : State(races)
}
