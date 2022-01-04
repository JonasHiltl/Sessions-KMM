package com.example.sessions_clean.android

import com.example.sessions_clean.android.ui.screens.auth.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {
    viewModel { LoginViewModel() }
}