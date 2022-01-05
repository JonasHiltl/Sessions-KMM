package com.example.sessions_clean.android.di

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.interactors.auth.login.LoginInteractor
import com.example.sessions_clean.interactors.auth.register.RegisterInteractor
import org.koin.dsl.module

val interactorsModule = module {
    single { LoginInteractor(get<AuthService>()) }
    single { RegisterInteractor(get<AuthService>()) }
}