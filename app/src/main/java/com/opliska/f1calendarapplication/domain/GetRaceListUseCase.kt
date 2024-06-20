package com.opliska.f1calendarapplication.domain

import com.opliska.f1calendarapplication.data.RaceRepository
import com.opliska.f1calendarapplication.data.RequestResult
import com.opliska.f1calendarapplication.data.map
import com.opliska.f1calendarapplication.data.toRaceUI
import com.opliska.f1calendarapplication.presentation.RaceUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRaceListUseCase @Inject constructor(
    private val repository: RaceRepository
) {
    operator fun invoke(): Flow<RequestResult<List<RaceUI>>> {
        return repository.getAll().map { requestResult ->
            requestResult.map { races -> races.map { it.toRaceUI() } }
        }
    }
}