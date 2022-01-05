package com.example.sessions_clean.android.ui.screens.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sessions_clean.interactors.auth.login.Login
import com.example.sessions_clean.presentation.auth.login.LoginEvents
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel(
    private val login: Login
) : ViewModel() {
    private val _usernameOrEmail = MutableStateFlow("")
    val usernameOrEmail: StateFlow<String> = _usernameOrEmail

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onTriggerEvent(event: LoginEvents) {
        when (event) {
            LoginEvents.Login -> {
                login.execute(usernameOrEmail = usernameOrEmail.value, password = password.value)
                // TODO: Use shared Auth Service 
            }
        }
    }

    private fun login(usernameOrEmail: String, password: String) {
        login.execute(
            usernameOrEmail = usernameOrEmail,
            password = password
        ).collect(
            viewModelScope
        ) {

            it.message?.let {
                println("Add message to central queue")
                // TODO: Add to central Queue
            }
        }


    }
}