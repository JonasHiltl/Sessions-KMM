package com.example.sessions.android.ui.screens.home.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sessions.presentation.auth.login.LoginEvents
import com.example.sessions.presentation.home.search.SearchEvents
import com.example.sessions.presentation.home.search.SearchState

class SearchViewModel() : ViewModel() {
    val state = mutableStateOf(SearchState())

    fun onTriggerEvent(event: SearchEvents) {
        when (event) {
            is SearchEvents.OnUpdateQuery -> {
                state.value = state.value.copy(query = event.query)
            }
        }
    }
}