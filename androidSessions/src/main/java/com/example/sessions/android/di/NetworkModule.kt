package com.example.sessions.android.di

import com.example.sessions.datasource.network.KtorClientFactory
import com.example.sessions.datasource.network.auth.AuthService
import com.example.sessions.datasource.network.auth.AuthServiceImpl
import com.example.sessions.datasource.network.friends.FriendService
import com.example.sessions.datasource.network.friends.FriendServiceImpl
import com.example.sessions.datasource.network.profile.ProfileService
import com.example.sessions.datasource.network.profile.ProfileServiceImpl
import com.example.sessions.domain.util.Constants
import com.example.sessions.domain.util.settings
import org.koin.dsl.module
import io.ktor.client.*

val networkModule = module {
    factory { "http://DESKTOP-IFLCV1B:8000" }

    single<HttpClient> { KtorClientFactory().build(settings.getString(Constants.AUTH_TOKEN)) }

    single<AuthService> { AuthServiceImpl(get(), get()) }
    single<FriendService> { FriendServiceImpl(get(), get()) }
    single<ProfileService> { ProfileServiceImpl(get(), get()) }
}