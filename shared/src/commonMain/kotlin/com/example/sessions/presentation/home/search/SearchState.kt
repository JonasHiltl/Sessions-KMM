package com.example.sessions.presentation.home.search

data class SearchState(
    val query: String = ""
) {
    constructor() : this(
        query = ""
    )
}
