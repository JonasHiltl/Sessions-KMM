package com.example.sessions_clean.android.di

import androidx.appcompat.app.AppCompatActivity
import com.example.sessions_clean.android.ui.providers.AuthStateController
import com.example.sessions_clean.android.ui.providers.NotificationQueueState
import org.koin.dsl.module

val appModule = module {
    single { NotificationQueueState() }

    single { AuthStateController(get()) }
}