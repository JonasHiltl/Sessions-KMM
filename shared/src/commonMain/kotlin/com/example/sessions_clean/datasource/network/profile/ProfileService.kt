package com.example.sessions_clean.datasource.network.profile

import com.example.sessions_clean.model.Profile

interface ProfileService {
    suspend fun get(id: String): Profile

    suspend fun me(): Profile

    suspend fun checkProfileName(username: String): Boolean
}