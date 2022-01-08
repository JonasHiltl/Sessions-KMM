package com.example.sessions_clean.interactors.auth.login

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.auth.model.LoginRes
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.domain.global_state.auth.AuthState
import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.domain.model.MessageVariant
import com.example.sessions_clean.domain.util.*
import com.russhwolf.settings.ExperimentalSettingsApi
import kotlinx.coroutines.flow.flow

class LoginInteractor(
    private val authService: AuthService,
    private val profileService: ProfileService,
) {
    @ExperimentalSettingsApi
    fun execute(
        usernameOrEmail: String,
        password: String,
    ): CommonFlow<DataState<LoginRes>> = flow {
        try {
            emit(DataState.loading())

            val loginRes = authService.login(usernameOrEmail, password)

            settings.putString(Constants.AUTH_TOKEN, loginRes.token)

            val me = profileService.me()

            emit(
                DataState.data(
                    message = GenericNotification.Builder()
                        .id(loginRes.message)
                        .message(loginRes.message)
                        .variant(MessageVariant.SUCCESS)
                        .build(),
                    data = loginRes
                )
            )
        } catch (e: Exception) {
            emit(
                DataState.error<LoginRes>(
                    message = GenericNotification.Builder()
                        .id("LoginInterceptor.Error")
                        .message(e.message ?: "Login Interceptor Error")
                        .variant(MessageVariant.ERROR)
                        .build()
                )
            )
        }
    }.asCommonFlow()
}