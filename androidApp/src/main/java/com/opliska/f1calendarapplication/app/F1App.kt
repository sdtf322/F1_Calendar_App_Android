package com.opliska.f1calendarapplication.app

import android.app.Application
import com.opliska.f1calendarapplication.di.androidModule
import com.opliska.shared.di.KoinInit
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class F1App : Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInit().init {
            androidLogger(level = if (com.russhwolf.settings.BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@F1App)
            modules(
                listOf(
                    androidModule,
                ),
            )
        }
    }
}