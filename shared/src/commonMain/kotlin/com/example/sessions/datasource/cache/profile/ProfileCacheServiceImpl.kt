package com.example.sessions.datasource.cache.profile

import com.example.sessions.datasource.cache.*
import com.example.sessions.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileCacheServiceImpl(
    private val sessionDatabase: SessionDatabase
) : ProfileCacheService {
    private val queries: ProfileEntityQueries = sessionDatabase.profileEntityQueries

    override fun add(profile: Profile) {
        TODO("Not yet implemented")
    }

    override fun add(profiles: List<Profile>) {
        TODO("Not yet implemented")
    }

    override fun get(id: Long): Flow<Profile>? {
        TODO("Not yet implemented")
    }

}