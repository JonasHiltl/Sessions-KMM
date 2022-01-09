package com.example.sessions_clean.android.ui.providers

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import com.example.sessions_clean.domain.global_state.AuthState
import com.example.sessions_clean.domain.util.Constants
import com.example.sessions_clean.domain.util.settings
import com.example.sessions_clean.interactors.auth.GetMeInterceptor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.compose.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthState : KoinComponent {
    val state: MutableState<AuthState> = mutableStateOf(AuthState())
    val getMeInterceptor: GetMeInterceptor by inject()

    fun logout() {
        state.value = state.value.copy(isAuthenticated = false, profile = null, authToken = "")
    }

    fun fetchMe() {
        val me = getMeInterceptor.execute().collect(CoroutineScope(Dispatchers.IO)) { dataState ->
            println(dataState.message)
            dataState.data?.let {
                println("Found Profile in init function")
                println(it)
                state.value =
                    state.value.copy(profile = it, isAuthenticated = true, isLoading = false)
            }
        }
    }

    init {
        val token = settings.getString(Constants.AUTH_TOKEN)
        if (token.isNotBlank()) {
            fetchMe()
            state.value = state.value.copy(authToken = token)
        }
    }
}

val LocalAuthState =
    compositionLocalOf { com.example.sessions_clean.android.ui.providers.AuthState() }