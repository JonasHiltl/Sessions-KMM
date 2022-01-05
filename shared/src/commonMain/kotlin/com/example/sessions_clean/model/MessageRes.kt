package com.example.sessions_clean.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageRes(
    @SerialName("message")
    var message: String,
)
