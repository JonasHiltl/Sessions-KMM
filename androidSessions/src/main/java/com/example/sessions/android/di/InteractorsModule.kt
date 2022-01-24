package com.example.sessions.android.di

import com.example.sessions.interactors.auth.GetMeInterceptor
import com.example.sessions.interactors.auth.LoginInteractor
import com.example.sessions.interactors.auth.RegisterInteractor
import com.example.sessions.interactors.friends.GetFriends
import org.koin.dsl.module

val interactorsModule = module {
    single { LoginInteractor(get()) }
    single { RegisterInteractor(get(), get()) }
    single { GetMeInterceptor(get()) }
    single { GetFriends(get()) }
}