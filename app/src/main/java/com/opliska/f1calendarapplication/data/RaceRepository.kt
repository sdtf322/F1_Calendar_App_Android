package com.opliska.f1calendarapplication.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.opliska.f1calendarapplication.common.Logger
import com.opliska.f1calendarapplication.data.database.RaceDatabase
import com.opliska.f1calendarapplication.data.database.model.RaceDBO
import com.opliska.f1calendarapplication.data.model.Race
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@ExperimentalCoroutinesApi
class RaceRepository @Inject constructor(
    private val database: RaceDatabase,
    private val logger: Logger
) {

    private val firebaseDatabase = Firebase.database
    private val firebaseDatabaseReference: DatabaseReference = firebaseDatabase.getReference("races2024")

    fun getAll(
        mergeStrategy: MergeStrategy<RequestResult<List<Race>>> = RequestResponseMergeStrategy()
    ): Flow<RequestResult<List<Race>>> {
        val cachedAllArticles: Flow<RequestResult<List<Race>>> = gelAllFromDatabase()
        val remoteArticles: Flow<RequestResult<List<Race>>> = getAllFromServer()

        return cachedAllArticles.combine(remoteArticles, mergeStrategy::merge)
            .flatMapLatest { result ->
                if (result is RequestResult.Success) {
                    database.racesDao.observeAll()
                        .map { dbos -> dbos.map { it.toRace() } }
                        .map { RequestResult.Success(it) }
                } else {
                    flowOf(result)
                }
            }
    }

    private fun getAllFromServer(): Flow<RequestResult<List<Race>>> {
        val apiRequest = callbackFlow {
            val racesListener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val racesList = snapshot.children.mapNotNull { dataSnapshot ->
                        val race = dataSnapshot.getValue(Race::class.java)
                        if (race == null) {
                            logger.d(LOG_TAG, "Failed to deserialize Race: ${dataSnapshot.value}")
                        } else {
                            if (race.circuit == null) {
                                logger.d(LOG_TAG, "Race with null Circuit: $race")
                            }
                        }
                        race
                    }

                    trySend(Result.success(racesList)).isSuccess
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Result.failure(Exception(error.message))).isSuccess
                }
            }
            firebaseDatabaseReference.addValueEventListener(racesListener)
            awaitClose { firebaseDatabaseReference.removeEventListener(racesListener) }
        }
            .onEach { result ->
                if (result.isSuccess) {
                    saveRacesToCache(result.getOrThrow())
                }
            }
            .onEach { result ->
                if (result.isFailure) {
                    logger.e(
                        LOG_TAG,
                        "Error getting data from server. Cause = ${result.exceptionOrNull()}"
                    )
                }
            }
            .map { it.toRequestResult() }
            .catch { e ->
                emit(RequestResult.Error(error = e))
            }

        val start = flowOf<RequestResult<List<Race>>>(RequestResult.InProgress())
        return merge(apiRequest, start)
    }


    private suspend fun saveRacesToCache(data: List<Race>) {
        val dbos = data.map { race -> race.toRaceDBO() }
        database.racesDao.insert(dbos)
    }

    private fun gelAllFromDatabase(): Flow<RequestResult<List<Race>>> {
        val dbRequest =
            database.racesDao::getAll.asFlow()
                .map<List<RaceDBO>, RequestResult<List<RaceDBO>>> { RequestResult.Success(it) }
                .catch {
                    logger.e(LOG_TAG, "Error getting from database. Cause = $it")
                    emit(RequestResult.Error(error = it))
                }

        val start = flowOf<RequestResult<List<RaceDBO>>>(RequestResult.InProgress())

        return merge(start, dbRequest).map { result ->
            result.map { dbos -> dbos.map { it.toRace() } }
        }
    }

    private companion object {
        const val LOG_TAG = "RacesRepository"
    }
}

