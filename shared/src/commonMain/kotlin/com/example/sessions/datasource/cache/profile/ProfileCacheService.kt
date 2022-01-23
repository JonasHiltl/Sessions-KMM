package com.example.sessions.datasource.cache.profile

import com.example.sessions.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileCacheService {
    fun add(profile: Profile)

    fun add(profiles: List<Profile>)

    fun get(id: Long): Flow<Profile>?
}