package com.example.sessions_clean.android.di

import androidx.navigation.compose.rememberNavController
import com.example.sessions_clean.domain.global_state.auth.AuthState
import org.koin.dsl.module

val appModule = module {
    single { AuthState() }
}