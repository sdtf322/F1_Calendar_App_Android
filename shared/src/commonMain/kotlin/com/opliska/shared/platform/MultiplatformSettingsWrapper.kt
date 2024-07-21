package com.opliska.shared.platform

import com.russhwolf.settings.Settings

expect class MultiplatformSettingsWrapper {
    fun createSettings(): Settings
}