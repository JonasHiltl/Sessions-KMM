package com.example.sessions_clean.android.ui.screens.auth

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _usernameOrEmail = MutableStateFlow("")
    val username: StateFlow<String> = _usernameOrEmail

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password
}