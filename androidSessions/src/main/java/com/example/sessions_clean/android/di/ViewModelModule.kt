package com.example.sessions_clean.android.di

import com.example.sessions_clean.android.ui.screens.auth.login.LoginViewModel
import com.example.sessions_clean.android.ui.screens.auth.person.RegisterViewModel
import com.example.sessions_clean.interactors.auth.login.LoginInteractor
import com.example.sessions_clean.interactors.auth.register.RegisterInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel(get<LoginInteractor>()) }
    viewModel { RegisterViewModel(get<RegisterInteractor>()) }
}