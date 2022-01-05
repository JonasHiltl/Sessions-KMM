package com.example.sessions_clean.presentation.auth.login

data class LoginState(
    val usernameOrEmail: String = "",
    val password: String = "",
) {
    constructor() : this(
        usernameOrEmail = "",
        password = ""
    )
}
