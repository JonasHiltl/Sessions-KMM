package com.example.sessions.android.providers

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.example.sessions.domain.global_state.AuthState
import com.example.sessions.domain.util.Constants
import com.example.sessions.domain.util.settings
import com.example.sessions.interactors.auth.GetMeInterceptor

class AuthStateController(
    private val getMeInterceptor: GetMeInterceptor
) {
    val state: MutableState<AuthState> = mutableStateOf(AuthState())

    fun logout() {
        state.value = state.value.copy(isAuthenticated = false, profile = null, authToken = "")
    }

    fun fetchMe() {
        val me = getMeInterceptor.execute().collect() { dataState ->
            dataState.data?.let {
                println("You are: ${it.firstname} ${it.lastname}. With id: ${it.id}")
                state.value =
                    state.value.copy(profile = it, isAuthenticated = true, isLoading = false)
            }
            dataState.isError.let {
                if (it) state.value = state.value.copy(isAuthenticated = false, isLoading = false)
            }
        }
    }

    init {
        val token = settings.getString(Constants.AUTH_TOKEN)
        state.value = state.value.copy(authToken = token)
        fetchMe()

    }
}

val LocalAuthState =
    compositionLocalOf {
        AuthState()
    }