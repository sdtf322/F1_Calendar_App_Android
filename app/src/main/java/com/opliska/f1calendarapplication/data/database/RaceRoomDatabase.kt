package com.opliska.f1calendarapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.opliska.f1calendarapplication.data.database.dao.RaceDao
import com.opliska.f1calendarapplication.data.database.model.RaceDBO

class RaceDatabase internal constructor(private val database: F1RoomDatabase) {
    val racesDao: RaceDao
        get() = database.racesDao()
}

@Database(entities = [RaceDBO::class], version = 1)
internal abstract class F1RoomDatabase : RoomDatabase() {
    abstract fun racesDao(): RaceDao
}

fun RaceDatabase(applicationContext: Context): RaceDatabase {
    val newsRoomDatabase =
        Room.databaseBuilder(
            checkNotNull(applicationContext.applicationContext),
            F1RoomDatabase::class.java,
            "news"
        ).build()
    return RaceDatabase(newsRoomDatabase)
}