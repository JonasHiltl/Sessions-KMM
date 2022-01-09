package com.example.sessions_clean.android.ui.screens.auth.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sessions_clean.android.ui.components.notification_queue.NotificationQueueState
import com.example.sessions_clean.interactors.auth.login.LoginInteractor
import com.example.sessions_clean.presentation.auth.login.LoginEvents
import com.example.sessions_clean.presentation.auth.login.LoginState

class LoginViewModel(
    private val loginInteractor: LoginInteractor,
    private val notificationQueueState: NotificationQueueState,
) : ViewModel() {
    val state: MutableState<LoginState> = mutableStateOf(LoginState())

    fun onTriggerEvent(event: LoginEvents) {
        when (event) {
            LoginEvents.Login -> {
                login(
                    usernameOrEmail = state.value.usernameOrEmail,
                    password = state.value.password
                )
            }
            is LoginEvents.OnUpdateUsernameOrEmail -> {
                state.value = state.value.copy(usernameOrEmail = event.usernameOrEmail)
            }
            is LoginEvents.OnUpdatePassword -> {
                state.value = state.value.copy(password = event.password)
            }
        }
    }

    private fun login(usernameOrEmail: String, password: String) {
        loginInteractor.execute(
            usernameOrEmail = usernameOrEmail,
            password = password
        ).collect(
            viewModelScope
        ) { it ->
            it.message?.let {
                notificationQueueState.addNotification(it)
            }
        }
    }
}