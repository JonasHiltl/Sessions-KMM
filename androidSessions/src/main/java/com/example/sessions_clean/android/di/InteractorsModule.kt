package com.example.sessions_clean.android.di

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.domain.global_state.auth.AuthState
import com.example.sessions_clean.interactors.auth.login.LoginInteractor
import com.example.sessions_clean.interactors.auth.register.RegisterInteractor
import org.koin.dsl.module

val interactorsModule = module {
    single { LoginInteractor(get<AuthService>(), get<ProfileService>()) }
    single { RegisterInteractor(get<AuthService>(), get<ProfileService>()) }
}