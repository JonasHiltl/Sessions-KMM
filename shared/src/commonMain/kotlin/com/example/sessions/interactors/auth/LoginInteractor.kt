package com.example.sessions.interactors.auth

import com.example.sessions.datasource.network.auth.AuthService
import com.example.sessions.datasource.network.auth.model.LoginRes
import com.example.sessions.datasource.network.auth.model.toLoginRes
import com.example.sessions.domain.model.GenericNotification
import com.example.sessions.domain.model.NotificationVariant
import com.example.sessions.domain.util.*
import com.russhwolf.settings.ExperimentalSettingsApi
import io.ktor.client.features.*
import io.ktor.client.statement.*
import io.ktor.http.*
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

            val loginResDto = authService.login(usernameOrEmail, password)

            settings.putString(Constants.AUTH_TOKEN, loginResDto.token)

            emit(
                DataState.data(
                    message = GenericNotification.Builder()
                        .message(loginResDto.message)
                        .variant(NotificationVariant.SUCCESS),
                    data = loginResDto.toLoginRes()
                )
            )
        } catch (e: ClientRequestException) {
            if (e.response.status == HttpStatusCode.Unauthorized) {
                emit(
                    DataState.error<LoginRes>(
                        message = GenericNotification.Builder()
                            .message("Jwt is missing")
                            .variant(NotificationVariant.ERROR),
                    )
                )
            } else {
                val res = e.response.readText()

                emit(
                    DataState.error<LoginRes>(
                        message = GenericNotification.Builder()
                            .message(errorRes = res)
                            .variant(NotificationVariant.ERROR),
                    )
                )
            }
        } catch (e: Exception) {
            println("Login Interceptor Error")
            println(e)
            emit(
                DataState.error<LoginRes>(
                    message = GenericNotification.Builder()
                        .message("Unrecognized Error")
                        .variant(NotificationVariant.ERROR),
                )
            )
        }
    }.asCommonFlow()
}