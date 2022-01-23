package com.example.sessions.domain.util

import com.example.sessions.domain.model.GenericNotification

class DataState<T>(
    val message: GenericNotification.Builder? = null,
    val data: T? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        fun <T> error(
            message: GenericNotification.Builder
        ): DataState<T> {
            return DataState(
                isLoading = false,
                message = message,
                data = null,
                isError = true,
            )
        }

        fun <T> data(
            message: GenericNotification.Builder? = null,
            data: T? = null
        ): DataState<T> {
            return DataState(
                isLoading = false,
                message = message,
                data = data,
            )
        }

        fun <T> loading() = DataState<T>(isLoading = true)
    }
}