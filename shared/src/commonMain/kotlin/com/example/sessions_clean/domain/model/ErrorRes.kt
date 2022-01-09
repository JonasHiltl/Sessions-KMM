package com.example.sessions_clean.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorRes(
    val statusCode: Int,
    val error: String,
    val message: String,
)
