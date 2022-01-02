package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.screens.auth.AccountSelectionScreen
import com.example.sessions_clean.android.ui.screens.auth.LoginScreen
import com.example.sessions_clean.android.ui.screens.auth.person.RegisterScreen
import com.example.sessions_clean.android.ui.screens.auth.company.RegisterCompanyScreen
import com.google.accompanist.navigation.animation.composable

const val transitionLength = 300
val slideTransitionSpec: FiniteAnimationSpec<IntOffset> =
    tween(transitionLength, easing = FastOutSlowInEasing)

val fadeTransitionSpec: FiniteAnimationSpec<Float> =
    tween(transitionLength, easing = FastOutSlowInEasing)

@ExperimentalAnimationApi
fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.AccountSelection.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(
            Screen.Login.route
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            Screen.Register.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -transitionLength },
                    animationSpec = slideTransitionSpec
                ) + fadeIn(fadeTransitionSpec)
            },
            exitTransition = null
        ) {
            RegisterScreen(navController = navController)
        }
        composable(
            Screen.AccountSelection.route,
            enterTransition = { EnterTransition.None },
            exitTransition = {
                fadeOut(fadeTransitionSpec)
            }
        ) {
            AccountSelectionScreen(navController = navController)
        }
        composable(
            Screen.RegisterCompany.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { transitionLength },
                    animationSpec = slideTransitionSpec
                ) + fadeIn(fadeTransitionSpec)
            },
            exitTransition = null
        ) {
            RegisterCompanyScreen(navController = navController)
        }
    }
}