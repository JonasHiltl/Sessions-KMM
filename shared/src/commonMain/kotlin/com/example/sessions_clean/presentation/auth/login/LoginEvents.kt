package com.example.sessions_clean.presentation.auth.login

sealed class LoginEvents {
    object Login : LoginEvents()

    data class OnUpdateUsernameOrEmail(val usernameOrEmail: String): LoginEvents()
    data class OnUpdatePassword(val password: String): LoginEvents()
}
