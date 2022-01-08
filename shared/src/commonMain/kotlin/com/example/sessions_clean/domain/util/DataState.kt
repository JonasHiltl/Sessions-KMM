package com.example.sessions_clean.domain.util

import com.example.sessions_clean.domain.model.GenericNotification

class DataState<T>(
    val message: GenericNotification? = null,
    val data: T? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        fun <T> error(
            message: GenericNotification
        ): DataState<T> {
            return DataState(
                message = message,
                data = null,
                isError = true,
            )
        }

        fun <T> data(
            message: GenericNotification? = null,
            data: T? = null
        ): DataState<T> {
            return DataState(
                message = message,
                data = data,
            )
        }

        fun <T> loading() = DataState<T>(isLoading = true)
    }
}