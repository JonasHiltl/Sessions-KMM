package com.example.sessions.android

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
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.example.sessions.android.ui.components.NotificationQueue
import com.example.sessions.android.providers.AuthStateController
import com.example.sessions.android.providers.LocalAuthState
import com.example.sessions.android.ui.screens.NavGraphs
import com.example.sessions.android.ui.theme.M3Theme
import com.example.sessions.android.ui.theme.Spacing
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.get

val localNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@OptIn(
    ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class,
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val authStateController: AuthStateController by inject()
        val isAuthenticated = authStateController.state.value.isAuthenticated

        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepVisibleCondition {
                authStateController.state.value.isLoading
            }
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberAnimatedNavController(bottomSheetNavigator)
            val engine = rememberAnimatedNavHostEngine()

            ProvideWindowInsets() {
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
                                DestinationsNavHost(
                                    navController = navController,
                                    navGraph = if (authStateController.state.value.isAuthenticated) NavGraphs.root else NavGraphs.auth,
                                    engine = engine,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
