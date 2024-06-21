package com.opliska.f1calendarapplication.data

import com.opliska.f1calendarapplication.data.model.Race
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RaceRepository @Inject constructor() {

    fun getAll(): Flow<RequestResult<List<Race>>> {
        val mockData = listOf(
            Race(
                id = 1,
                title = "Canadian Grand Prix",
                description = "25-27 MARCH",
                imageUrl = null),
            Race(
                id = 2,
                title = "Australian Grand Prix",
                description = "14-16 APRIL",
                imageUrl = null),
            Race(
                id = 3,
                title = "Estonian Grand Prix",
                description = "16-18 JUNE",
                imageUrl = null),
        )
        return flowOf(RequestResult.Success(mockData))
    }

    //Todo implement get all function for race repository
//    public fun getAll(
//        query: String,
//        mergeStrategy: MergeStrategy<RequestResult<List<Article>>> = RequestResponseMergeStrategy()
//    ): Flow<RequestResult<List<Article>>> {
//        val cachedAllArticles: Flow<RequestResult<List<Article>>> = gelAllFromDatabase()
//        val remoteArticles: Flow<RequestResult<List<Article>>> = getAllFromServer(query)
//
//        return cachedAllArticles.combine(remoteArticles, mergeStrategy::merge)
//            .flatMapLatest { result ->
//                if (result is RequestResult.Success) {
//                    database.articlesDao.observeAll()
//                        .map { dbos -> dbos.map { it.toArticle() } }
//                        .map { RequestResult.Success(it) }
//                } else {
//                    flowOf(result)
//                }
//            }
//    }
}