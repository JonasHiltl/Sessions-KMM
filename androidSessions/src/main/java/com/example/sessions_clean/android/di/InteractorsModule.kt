package com.example.sessions_clean.android.di

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.interactors.auth.login.Login
import com.example.sessions_clean.interactors.auth.register.Register
import org.koin.dsl.module

val interactorsModule = module {
    single { Login(get<AuthService>()) }
    single { Register(get<AuthService>()) }
}