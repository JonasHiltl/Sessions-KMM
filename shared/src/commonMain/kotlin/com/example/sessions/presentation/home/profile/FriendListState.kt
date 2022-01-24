package com.example.sessions.presentation.home.profile

import com.example.sessions.model.Profile

data class FriendListState(
    val friends: List<Profile> = emptyList(),
    val isLoading: Boolean = false,
) {
    constructor() : this(
        friends = emptyList(),
        isLoading = false
    )
}
