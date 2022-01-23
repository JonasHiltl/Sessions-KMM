package com.example.sessions.presentation.auth.login

data class LoginState(
    val usernameOrEmail: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
) {
    constructor() : this(
        usernameOrEmail = "",
        password = "",
        isLoading = false
    )
}
