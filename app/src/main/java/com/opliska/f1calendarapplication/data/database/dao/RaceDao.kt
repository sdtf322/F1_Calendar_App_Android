package com.opliska.f1calendarapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.opliska.f1calendarapplication.data.database.model.RaceDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface RaceDao {
    @Query("SELECT * FROM races")
    suspend fun getAll(): List<RaceDBO>

    @Query("SELECT * FROM races")
    fun observeAll(): Flow<List<RaceDBO>>

    @Query("DELETE FROM races")
    suspend fun clean()
}