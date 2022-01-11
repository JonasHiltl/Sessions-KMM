package com.example.sessions_clean.interactors.auth

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.auth.model.LoginRes
import com.example.sessions_clean.datasource.network.auth.model.RegisterRes
import com.example.sessions_clean.datasource.network.auth.model.toRegisterRes
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.domain.model.NotificationVariant
import com.example.sessions_clean.domain.util.*
import io.ktor.client.features.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.flow

class RegisterInteractor(
    private val authService: AuthService,
    private val profileService: ProfileService,
) {
    fun execute(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): CommonFlow<DataState<RegisterRes>> = flow {
        try {
            emit(DataState.loading())

            val registerResDto =
                authService.register(username, firstname, lastname, email, password)

            settings.putString(Constants.AUTH_TOKEN, registerResDto.token)

            val me = profileService.me()

            emit(
                DataState.data(
                    message = GenericNotification.Builder()
                        .message(registerResDto.message)
                        .variant(NotificationVariant.SUCCESS),
                    data = registerResDto.toRegisterRes()
                )
            )
        } catch (e: ClientRequestException) {
            if (e.response.status == HttpStatusCode.Unauthorized) {
                emit(
                    DataState.error<RegisterRes>(
                        message = GenericNotification.Builder()
                            .message("Jwt is missing")
                            .variant(NotificationVariant.ERROR),
                    )
                )
            } else {
                val res = e.response.readText()

                emit(
                    DataState.error<RegisterRes>(
                        message = GenericNotification.Builder()
                            .message(errorRes = res)
                            .variant(NotificationVariant.ERROR),
                    )
                )
            }
        } catch (e: Exception) {
            emit(
                DataState.error<RegisterRes>(
                    message = GenericNotification.Builder()
                        .message("Unrecognized Error")
                        .variant(NotificationVariant.ERROR),
                )
            )
        }

    }.asCommonFlow()
}