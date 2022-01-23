package com.example.sessions.presentation.auth.register

data class RegisterState(
    val username: String = "",
    val firstname: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String = "",
    val rePassword: String = "",
    val isLoading: Boolean = false,
) {
    constructor() : this(
        username = "",
        firstname = "",
        lastname = "",
        email = "",
        password = "",
        rePassword = "",
        isLoading = false,
    )
}
