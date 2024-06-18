package com.opliska.f1calendarapplication.presentation.race_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.data.toState
import com.opliska.f1calendarapplication.domain.GetRaceListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

//Todo update use case
@HiltViewModel
class RaceListViewModel @Inject constructor(
    getRaceListUseCase: Provider<GetRaceListUseCase>
) : ViewModel() {

    val state: StateFlow<State> =
        getRaceListUseCase.get().invoke()
            .map { it.toState() }
            .stateIn(viewModelScope, SharingStarted.Lazily, State.None)
}