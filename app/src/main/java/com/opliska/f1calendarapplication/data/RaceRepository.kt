package com.opliska.f1calendarapplication.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.opliska.f1calendarapplication.data.model.Race
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class RaceRepository @Inject constructor() {

    private val database = Firebase.database
    private val databaseReference: DatabaseReference = database.getReference("races2024")

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
        databaseReference.addValueEventListener(racesListener)
        awaitClose { databaseReference.removeEventListener(racesListener) }
    }.catch { e ->
        emit(RequestResult.Error(error = e))
    }
}

