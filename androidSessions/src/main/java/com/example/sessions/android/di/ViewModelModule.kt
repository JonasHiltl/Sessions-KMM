package com.example.sessions.android.di

import com.example.sessions.android.providers.AuthStateController
import com.example.sessions.android.ui.screens.auth.login.LoginViewModel
import com.example.sessions.android.ui.screens.auth.person.RegisterViewModel
import com.example.sessions.android.ui.screens.home.profile.components.FriendListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { RegisterViewModel(get(), get(), get()) }
    viewModel { FriendListViewModel(get(), get<AuthStateController>().state.value) }
}