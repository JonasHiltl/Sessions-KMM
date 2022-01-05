package com.example.sessions_clean.android.ui.screens.auth.person

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sessions_clean.interactors.auth.register.RegisterInteractor
import com.example.sessions_clean.presentation.auth.login.LoginEvents
import com.example.sessions_clean.presentation.auth.register.RegisterEvents
import com.example.sessions_clean.presentation.auth.register.RegisterState

class RegisterViewModel(
    private val registerInteractor: RegisterInteractor
) : ViewModel() {
    val state: MutableState<RegisterState> = mutableStateOf(RegisterState())

    fun onTriggerEvent(event: RegisterEvents) {
        when (event) {
            RegisterEvents.Register -> {
                register(
                    username = state.value.username,
                    firstname = state.value.firstname,
                    email = state.value.email,
                    lastname = state.value.lastname,
                    password = state.value.password
                )
            }
        }
    }

    private fun register(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ) {
        registerInteractor.execute(
            username,
            firstname,
            lastname,
            email,
            password
        )
            .collect(viewModelScope) {
                it.message?.let {
                    println("Add message to central queue")
                    // TODO: Add to central Queue
                }
            }
    }
}