package com.opliska.f1calendarapplication.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.opliska.f1calendarapplication.BuildConfig

class App : Application() {

    //Todo need a succesful build for generating a BuildConfig
    override fun onCreate() {
        super.onCreate()

        val options = FirebaseOptions.Builder()
            .setApiKey(BuildConfig.FIREBASE_API_KEY)
            .setApplicationId(BuildConfig.FIREBASE_APP_ID)
            .setProjectId(BuildConfig.FIREBASE_PROJECT_ID)
            .build()

        FirebaseApp.initializeApp(this, options)
    }
}