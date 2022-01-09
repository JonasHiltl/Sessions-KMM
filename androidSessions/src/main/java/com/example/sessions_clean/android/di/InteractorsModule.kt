package com.example.sessions_clean.android.di

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.interactors.auth.GetMeInterceptor
import com.example.sessions_clean.interactors.auth.LoginInteractor
import com.example.sessions_clean.interactors.auth.RegisterInteractor
import org.koin.dsl.module

val interactorsModule = module {
    single { LoginInteractor(get()) }
    single { RegisterInteractor(get(), get()) }
    single { GetMeInterceptor(get()) }
}