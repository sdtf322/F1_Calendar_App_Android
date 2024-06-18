package com.opliska.f1calendarapplication.domain

import com.opliska.f1calendarapplication.data.RaceRepository
import com.opliska.f1calendarapplication.data.RequestResult
import com.opliska.f1calendarapplication.presentation.RaceUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRaceListUseCase @Inject constructor(
    private val repository: RaceRepository
) {
    //Todo create a repository mock function which will return hard-coded list
    operator fun invoke(): Flow<RequestResult<List<RaceUI>>> {
        return repository.getAll().map { requestResult ->
            requestResult.map { articles -> articles.map { it.toUiArticle() } }
        }
    }
}