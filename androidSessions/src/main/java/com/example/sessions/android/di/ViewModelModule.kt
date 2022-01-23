package com.example.sessions.android.di

import com.example.sessions.android.ui.screens.auth.login.LoginViewModel
import com.example.sessions.android.ui.screens.auth.person.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { RegisterViewModel(get(), get(), get()) }
}