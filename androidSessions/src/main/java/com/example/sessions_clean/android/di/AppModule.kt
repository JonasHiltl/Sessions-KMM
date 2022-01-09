package com.example.sessions_clean.android.di

import com.example.sessions_clean.android.ui.providers.AuthState
import com.example.sessions_clean.android.ui.providers.NotificationQueueState
import org.koin.dsl.module

val appModule = module {
    single { AuthState() }
    single { NotificationQueueState() }
}