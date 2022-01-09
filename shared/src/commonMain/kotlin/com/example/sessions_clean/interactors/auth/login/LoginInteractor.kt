package com.example.sessions_clean.interactors.auth.login

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.auth.model.LoginRes
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.domain.model.NotificationVariant
import com.example.sessions_clean.domain.util.*
import com.russhwolf.settings.ExperimentalSettingsApi
import io.ktor.client.features.*
import io.ktor.client.statement.*
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
                        .variant(NotificationVariant.SUCCESS),
                    data = loginRes
                )
            )
        } catch (e: ClientRequestException) {
            val res = e.response.readText()

            emit(
                DataState.error<LoginRes>(
                    message = GenericNotification.Builder()
                        .id("LoginInterceptor.Error.Ktor")
                        .message(errorRes = res)
                        .variant(NotificationVariant.ERROR),
                )
            )
        } catch (e: Exception) {
            emit(
                DataState.error<LoginRes>(
                    message = GenericNotification.Builder()
                        .id("LoginInterceptor.Error.Local")
                        .message("Unrecognized Error")
                        .variant(NotificationVariant.ERROR),
                )
            )
        }
    }.asCommonFlow()
}