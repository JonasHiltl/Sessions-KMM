package com.example.sessions_clean.interactors.auth

import com.example.sessions_clean.datasource.network.auth.model.toLoginRes
import com.example.sessions_clean.datasource.network.profile.ProfileService
import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.domain.model.NotificationVariant
import com.example.sessions_clean.domain.util.*
import com.example.sessions_clean.model.Profile
import io.ktor.client.features.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.flow

class GetMeInterceptor(
    private val profileService: ProfileService
) {
    fun execute(): CommonFlow<DataState<Profile>> = flow {
        try {
            emit(DataState.loading())

            val me = profileService.me()

            emit(
                DataState.data(
                    data = me
                )
            )
        } catch (e: ClientRequestException) {
            println("Get Me Interceptor error response")
            println(e)
            if (e.response.status === HttpStatusCode.Unauthorized) {
                emit(
                    DataState.error<Profile>(
                        message = GenericNotification.Builder()
                            .message("Jwt is missing")
                            .variant(NotificationVariant.ERROR),
                    )
                )
            } else {
                val res = e.response.readText()

                emit(
                    DataState.error<Profile>(
                        message = GenericNotification.Builder()
                            .message(errorRes = res)
                            .variant(NotificationVariant.ERROR),
                    )
                )
            }
        } catch (e: Exception) {
            println("Get me Interceptor Exception")
            println(e)
            emit(
                DataState.error<Profile>(
                    message = GenericNotification.Builder()
                        .message("Unrecognized Error")
                        .variant(NotificationVariant.ERROR),
                )
            )
        }
    }.asCommonFlow()
}