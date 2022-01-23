package com.example.sessions.android.di

import com.example.sessions.android.providers.AuthStateController
import com.example.sessions.android.providers.NotificationQueueState
import org.koin.dsl.module

val appModule = module {
    single { NotificationQueueState() }
    single { AuthStateController(get()) }
}