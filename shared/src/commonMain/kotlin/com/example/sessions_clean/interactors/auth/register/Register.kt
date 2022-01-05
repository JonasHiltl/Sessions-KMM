package com.example.sessions_clean.interactors.auth.register

import com.example.sessions_clean.datasource.network.auth.AuthService
import com.example.sessions_clean.domain.util.CommonFlow
import com.example.sessions_clean.domain.util.DataState
import com.example.sessions_clean.domain.util.asCommonFlow
import kotlinx.coroutines.flow.flow

class Register(
    private val authService: AuthService,
) {
    fun execute(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): CommonFlow<DataState<String>> = flow {
        try {
            emit(DataState.loading())

            val registerRes = authService.register(username, firstname, lastname, email, password)

            emit(DataState.data(message = registerRes.message, data = registerRes.token))
        } catch (e: Exception) {
            emit(
                DataState.error<String>(
                    message = "Test"
                )
            )
        }
    }.asCommonFlow()
}