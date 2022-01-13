package com.example.sessions_clean.domain.global_state

import com.example.sessions_clean.model.Profile

data class AuthState(
    var isAuthenticated: Boolean = false,
    var profile: Profile? = null,
    var authToken: String = "",
    var isLoading: Boolean = true,
) {
    constructor() : this(
        isAuthenticated = false,
        profile = null,
        authToken = "",
        isLoading = true
    )
}