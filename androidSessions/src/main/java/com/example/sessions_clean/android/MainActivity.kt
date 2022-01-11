package com.example.sessions_clean.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import com.example.sessions_clean.android.di.appModule
import com.example.sessions_clean.android.di.interactorsModule
import com.example.sessions_clean.android.di.networkModule
import com.example.sessions_clean.android.di.viewModelModule
import com.example.sessions_clean.android.ui.components.NotificationQueue
import com.example.sessions_clean.android.ui.navigation.nav_graph.SetupNavGraph
import com.example.sessions_clean.android.ui.providers.AuthStateController
import com.example.sessions_clean.android.ui.providers.LocalAuthState
import com.example.sessions_clean.android.ui.theme.M3Theme
import com.example.sessions_clean.android.ui.theme.Spacing
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.compose.get
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

val localNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@ExperimentalMaterialNavigationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val authStateController: AuthStateController by inject()

        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepVisibleCondition {
                authStateController.state.value.isLoading
            }
        }

        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberAnimatedNavController(bottomSheetNavigator)

            CompositionLocalProvider(
                localNavController provides navController,
                LocalAuthState provides authStateController.state.value
            ) {
                M3Theme(darkTheme = true) {
                    NotificationQueue(get()) {
                        ModalBottomSheetLayout(
                            bottomSheetNavigator,
                            modifier = Modifier.background(MaterialTheme.colorScheme.background),
                            sheetShape = RoundedCornerShape(
                                topStart = Spacing.l,
                                topEnd = Spacing.l
                            ),
                            sheetBackgroundColor = MaterialTheme.colorScheme.background,
                        ) {
                            SetupNavGraph()
                        }
                    }
                }
            }
        }
    }
}
