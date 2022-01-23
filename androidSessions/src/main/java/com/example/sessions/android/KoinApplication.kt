package com.example.sessions.android

import android.app.Application
import com.example.sessions.android.di.appModule
import com.example.sessions.android.di.interactorsModule
import com.example.sessions.android.di.networkModule
import com.example.sessions.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@KoinApplication)
            modules(listOf(appModule, networkModule, viewModelModule, interactorsModule))
        }

    }

}