package com.example.sessions_clean.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import com.example.sessions_clean.android.di.appModule
import com.example.sessions_clean.android.di.interactorsModule
import com.example.sessions_clean.android.di.networkModule
import com.example.sessions_clean.android.di.viewModelModule
import com.example.sessions_clean.android.ui.navigation.nav_graph.SetupNavGraph
import com.example.sessions_clean.android.ui.theme.M3Theme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


val localNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MainActivity)
            modules(listOf(appModule, networkModule, viewModelModule, interactorsModule))
        }

        setContent {
            CompositionLocalProvider(localNavController provides rememberAnimatedNavController()) {

                M3Theme() {
                    SetupNavGraph()
                }
            }
        }
    }
}
