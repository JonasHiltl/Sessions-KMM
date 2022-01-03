package com.example.sessions_clean.domain.util

import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import platform.Foundation.NSUserDefaults

@ExperimentalCoroutinesApi
@ExperimentalSettingsApi
actual val settings: FlowSettings =
    AppleSettings(NSUserDefaults.standardUserDefaults, true).toFlowSettings()