package com.example.sessions_clean.android.di

import com.example.sessions_clean.android.ui.components.notification_queue.NotificationQueueState
import com.example.sessions_clean.domain.global_state.auth.AuthState
import org.koin.dsl.module

val appModule = module {
    single { AuthState() }
    single { NotificationQueueState() }
}