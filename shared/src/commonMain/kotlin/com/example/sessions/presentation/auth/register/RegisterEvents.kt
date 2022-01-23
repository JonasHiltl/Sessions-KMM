package com.example.sessions.presentation.auth.register

sealed class RegisterEvents {
    object Register : RegisterEvents()

    data class OnUpdateUsername(val username: String): RegisterEvents()
    data class OnUpdateFirstname(val firstname: String): RegisterEvents()
    data class OnUpdateLastname(val lastname: String): RegisterEvents()
    data class OnUpdateEmail(val email: String): RegisterEvents()
    data class OnUpdatePassword(val password: String): RegisterEvents()
    data class OnUpdateRePassword(val rePassword: String): RegisterEvents()
}
