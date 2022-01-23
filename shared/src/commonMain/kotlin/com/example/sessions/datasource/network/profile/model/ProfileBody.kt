package com.example.sessions.datasource.network.profile.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileBody(
    val username: String,
    val firstname: String,
    val lastname: String,
)
