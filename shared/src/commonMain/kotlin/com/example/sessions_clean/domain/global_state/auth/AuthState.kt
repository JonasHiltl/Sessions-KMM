package com.example.sessions_clean.domain.global_state.auth

import com.example.sessions_clean.model.Profile

class AuthState(
    var isAuthenticated: Boolean? = false,
    var profile: Profile? = null,
    var authToken: String = "",
) {
    constructor() : this(
        isAuthenticated = false,
        profile = null,
        authToken = ""
    )
}