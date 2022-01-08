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
            is RegisterEvents.OnUpdateUsername -> {
                state.value = state.value.copy(username = event.username)
            }
            is RegisterEvents.OnUpdateFirstname -> {
                state.value = state.value.copy(firstname = event.firstname)
            }
            is RegisterEvents.OnUpdateLastname -> {
                state.value = state.value.copy(lastname = event.lastname)
            }
            is RegisterEvents.OnUpdateEmail -> {
                state.value = state.value.copy(email = event.email)
            }
            is RegisterEvents.OnUpdatePassword -> {
                state.value = state.value.copy(password = event.password)
            }
            is RegisterEvents.OnUpdateRePassword -> {
                state.value = state.value.copy(rePassword = event.rePassword)
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
                if (it.isError) {
                    println("Registration failed")
                }
            }
    }
}