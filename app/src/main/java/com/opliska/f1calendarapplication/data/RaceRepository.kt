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
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class RaceRepository @Inject constructor(
    private val database: RaceDatabase,
    private val logger: Logger
) {

    private val firebaseDatabase = Firebase.database
    private val firebaseDatabaseReference: DatabaseReference = firebaseDatabase.getReference("races2024")

    fun getAll(): Flow<RequestResult<List<Race>>> = callbackFlow {

        val racesListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val racesList = snapshot.children.mapNotNull { it.getValue(Race::class.java) }
                trySend(RequestResult.Success(racesList)).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(RequestResult.Error(error = Exception(error.message))).isSuccess
            }
        }
        firebaseDatabaseReference.addValueEventListener(racesListener)
        awaitClose { firebaseDatabaseReference.removeEventListener(racesListener) }
    }.catch { e ->
        emit(RequestResult.Error(error = e))
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
            result.map { dbos -> dbos.map { it.toArticle() } }
        }
    }

    private companion object {
        const val LOG_TAG = "RacesRepository"
    }

    //Todo Add remaining functions necessary for room and saving it to database
}

