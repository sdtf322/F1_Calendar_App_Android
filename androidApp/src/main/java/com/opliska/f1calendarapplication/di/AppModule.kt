package com.opliska.f1calendarapplication.di

import android.content.Context
import com.opliska.f1calendarapplication.app.AppDispatchers
import com.opliska.f1calendarapplication.common.AndroidLogcatLogger
import com.opliska.f1calendarapplication.common.Logger
import com.opliska.f1calendarapplication.data.database.RaceDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRaceDatabase(
        @ApplicationContext context: Context
    ): RaceDatabase {
        return RaceDatabase(context)
    }

    @Provides
    @Singleton
    fun provideAppCoroutineDispatchers(): AppDispatchers = AppDispatchers()

    @Provides
    fun provideLogger(): Logger = AndroidLogcatLogger()
}