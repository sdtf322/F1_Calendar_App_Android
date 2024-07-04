package com.opliska.f1calendarapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

class F1RoomDatabase {
}

//class NewsDatabase internal constructor(private val database: NewsRoomDatabase) {
//    val articlesDao: ArticleDao
//        get() = database.articlesDao()
//}
//
//@Database(entities = [ArticleDBO::class], version = 1)
//internal abstract class NewsRoomDatabase : RoomDatabase() {
//    abstract fun articlesDao(): ArticleDao
//}
//
//fun NewsDatabase(applicationContext: Context): NewsDatabase {
//    val newsRoomDatabase =
//        Room.databaseBuilder(
//            checkNotNull(applicationContext.applicationContext),
//            NewsRoomDatabase::class.java,
//            "news"
//        ).build()
//    return NewsDatabase(newsRoomDatabase)
//}