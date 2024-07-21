package com.opliska.shared.di

import com.opliska.shared.core.data.SettingsRepositoryImpl
import com.opliska.shared.core.data.local.setting.PreferenceManager
import com.opliska.shared.core.domain.SettingsRepository
import com.opliska.shared.main.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun commonModule() = module {
    /**
     * Database
     */
    /**
     * Database
     */

    //Todo implement database DI

    /**
     * Multiplatform-Settings
     */
    /**
     * Multiplatform-Settings
     */
    single<PreferenceManager> {
        PreferenceManager(settings = get())
    }

    /**
     * Repositories
     */

    /**
     * Repositories
     */
    single<SettingsRepository> {
        SettingsRepositoryImpl(
            preferenceManager = get(),
        )
    }

    /**
     * ViewModels
     */

    /**
     * ViewModels
     */

    //Todo impleent Screen VM DI when necessary

    single<MainViewModel> {
        MainViewModel(
            settingsRepository = get(),
        )
    }
}

expect fun platformModule(): Module