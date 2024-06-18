package com.opliska.f1calendarapplication.data

class RaceRepository {

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