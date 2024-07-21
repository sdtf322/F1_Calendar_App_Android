package com.opliska.shared.core.data

import com.opliska.shared.core.data.local.setting.PreferenceManager
import com.opliska.shared.core.domain.SettingsRepository
import kotlinx.coroutines.flow.Flow


class SettingsRepositoryImpl(
    private val preferenceManager: PreferenceManager,
) : SettingsRepository {
    override suspend fun saveAppTheme(theme: Int) {
        preferenceManager.setInt(key = PreferenceManager.APP_THEME, value = theme)
    }

    override fun getAppTheme(): Flow<Int?> {
        return preferenceManager.getInt(key = PreferenceManager.APP_THEME)
    }
}