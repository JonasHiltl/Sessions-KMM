package com.example.sessions.interactors.friends

import com.example.sessions.datasource.network.friends.FriendService
import com.example.sessions.domain.util.CommonFlow
import com.example.sessions.domain.util.DataState
import com.example.sessions.domain.util.asCommonFlow
import com.example.sessions.model.Profile
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GetFriends(
    private val friendService: FriendService
) {
    fun execute(id: Long): CommonFlow<DataState<List<Profile>>> = flow {
        try {
            emit(DataState.loading())

            val friends = friendService.get(id)

            emit(
                DataState.data(
                    data = friends
                )
            )
        } catch (e: Exception) {
            emit(
                DataState()
            )
        }
    }.asCommonFlow()
}