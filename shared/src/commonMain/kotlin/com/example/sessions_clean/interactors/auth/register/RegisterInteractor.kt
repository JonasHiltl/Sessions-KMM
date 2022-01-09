package com.example.sessions_clean.interactors.auth.register

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.datasource.network.auth.model.RegisterRes
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.domain.model.NotificationVariant
import com.example.sessions_clean.domain.util.*
import io.ktor.client.features.*
import io.ktor.client.statement.*
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

            val registerRes = authService.register(username, firstname, lastname, email, password)

            settings.putString(Constants.AUTH_TOKEN, registerRes.token)

            val me = profileService.me()

            emit(
                DataState.data(
                    message = GenericNotification.Builder()
                        .id(registerRes.message)
                        .message(registerRes.message)
                        .variant(NotificationVariant.SUCCESS),
                    data = registerRes
                )
            )
        } catch (e: ClientRequestException) {
            println("Catched a client exception")
            val res = e.response.readText()

            emit(
                DataState.error<RegisterRes>(
                    message = GenericNotification.Builder()
                        .id("RegisterInterceptor.Error.Ktor")
                        .message(errorRes = res)
                        .variant(NotificationVariant.ERROR),
                )
            )
        } catch (e: Exception) {
            println("Catched a runtime exception ")
            emit(
                DataState.error<RegisterRes>(
                    message = GenericNotification.Builder()
                        .id("RegisterInterceptor.Error.Local")
                        .message("Unrecognized Error")
                        .variant(NotificationVariant.ERROR),
                )
            )
        }

    }.asCommonFlow()
}