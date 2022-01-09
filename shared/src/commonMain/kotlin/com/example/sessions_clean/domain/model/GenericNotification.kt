package com.example.sessions_clean.domain.model

import kotlinx.serialization.json.Json

enum class NotificationVariant {
    ERROR, SUCCESS
}

class GenericNotification
private constructor(builder: Builder) {
    val id: String
    val message: String
    val variant: NotificationVariant

    init {
        if (builder.id == null) {
            throw Exception("GenericDialog id cannot be null.")
        }
        if (builder.message == null) {
            throw Exception("GenericDialog message cannot be null.")
        }
        if (builder.variant == null) {
            throw Exception("GenericDialog variant cannot be null.")
        }
        this.id = builder.id!!
        this.message = builder.message!!
        this.variant = builder.variant!!
    }

    class Builder {
        var id: String? = null
            private set

        var message: String? = null
            private set

        var variant: NotificationVariant? = null
            private set

        fun id(id: String): Builder {
            this.id = id
            return this
        }

        fun message(message: String? = null, errorRes: String? = null): Builder {
            if (errorRes != null) {
                val error =
                    Json.decodeFromString(ErrorRes.serializer(), errorRes)
                this.message = error.message
            } else {
                this.message = message
            }

            return this
        }

        fun variant(variant: NotificationVariant): Builder {
            this.variant = variant
            return this
        }

        fun build() = GenericNotification(this)
    }
}
