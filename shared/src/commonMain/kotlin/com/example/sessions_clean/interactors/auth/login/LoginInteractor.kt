package com.example.sessions_clean.interactors.auth.login

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.auth.model.LoginRes
import com.example.sessions_clean.domain.util.CommonFlow
import com.example.sessions_clean.domain.util.DataState
import com.example.sessions_clean.domain.util.asCommonFlow
import com.example.sessions_clean.domain.util.settings
import com.russhwolf.settings.ExperimentalSettingsApi
import kotlinx.coroutines.flow.flow

class LoginInteractor(
    private val authService: AuthService,
) {
    @ExperimentalSettingsApi
    fun execute(
        usernameOrEmail: String,
        password: String,
    ): CommonFlow<DataState<LoginRes>> = flow {
        try {
            emit(DataState.loading())

            val loginRes = authService.login(usernameOrEmail, password)

            settings.putString("token", loginRes.token)

            emit(DataState.data(message = loginRes.message, data = loginRes))
        } catch (e: Exception) {
            emit(
                DataState.error<LoginRes>(
                    message = "Test"
                )
            )
        }
    }.asCommonFlow()
}