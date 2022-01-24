package com.example.sessions.android.ui.screens.home.profile.components

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sessions.domain.global_state.AuthState
import com.example.sessions.interactors.friends.GetFriends
import com.example.sessions.model.Friend
import com.example.sessions.model.Profile
import com.example.sessions.presentation.home.profile.FriendListState

class FriendListViewModel(
    private val getFriends: GetFriends,
    private val authState: AuthState
) : ViewModel() {
    val state = mutableStateOf(FriendListState())

    init {
        getFriends.execute(authState.profile!!.id).collect(viewModelScope) { dataState ->
            dataState.isLoading.let {
                state.value = state.value.copy(isLoading = it)
            }
            dataState.data?.let {
                state.value = state.value.copy(friends = it)
            }
        }
    }
}