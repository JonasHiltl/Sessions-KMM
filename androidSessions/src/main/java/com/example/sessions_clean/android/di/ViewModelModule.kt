package com.example.sessions_clean.android.di

import com.example.sessions_clean.android.ui.screens.auth.login.LoginViewModel
import com.example.sessions_clean.android.ui.screens.auth.person.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { RegisterViewModel(get(), get()) }
}