package com.example.sessions_clean.android.di

import com.example.sessions_clean.datasource.network.KtorClientFactory
import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.auth.AuthServiceImpl
import com.example.sessions_clean.datasource.network.friends.FriendService
import com.example.sessions_clean.datasource.network.friends.FriendServiceImpl
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.datasource.network.profile.ProfileServiceImpl
import org.koin.dsl.module
import io.ktor.client.*

val networkModule = module {
    factory { "http://DESKTOP-IFLCV1B:8000" }

    single<HttpClient> { KtorClientFactory().build() }

    single<AuthService> { AuthServiceImpl(get(), get()) }
    single<FriendService> { FriendServiceImpl(get(), get()) }
    single<ProfileService> { ProfileServiceImpl(get(), get()) }
}