package com.example.sessions.presentation.home.search

sealed class SearchEvents {
    data class OnUpdateQuery(val query: String) : SearchEvents()
}
