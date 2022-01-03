package com.example.sessions_clean.domain.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.datastore.DataStoreSettings

private val appContext: Context? = null

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Settings")

@ExperimentalSettingsApi
@ExperimentalSettingsImplementation
actual val settings: FlowSettings = DataStoreSettings(
    appContext?.dataStore ?: throw IllegalStateException("Context for Settings not initialized")
)