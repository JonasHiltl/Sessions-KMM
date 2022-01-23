package com.example.sessions.datasource.cache

import com.squareup.sqldelight.db.SqlDriver

class DatabaseFactory(
    private val driverFactory: DriverFactory
) {
    fun createDatabase(): SessionDatabase {
        return SessionDatabase(driverFactory.createDriver())
    }
}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}