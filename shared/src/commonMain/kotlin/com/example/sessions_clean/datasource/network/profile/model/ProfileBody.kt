package com.example.sessions_clean.datasource.network.profile.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileBody(
    val username: String,
    val firstname: String,
    val lastname: String,
)
