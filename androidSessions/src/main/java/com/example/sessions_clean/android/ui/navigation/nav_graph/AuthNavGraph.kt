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
import com.example.sessions_clean.android.ui.screens.auth.AccountSelection
import com.example.sessions_clean.android.ui.screens.auth.Login
import com.example.sessions_clean.android.ui.screens.auth.company.RegisterCompany
import com.example.sessions_clean.android.ui.screens.auth.person.Register
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
        startDestination = Screen.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(
            Screen.Login.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
        ) {
            Login(navController = navController)
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
            Register(navController = navController)
        }
        composable(
            Screen.AccountSelection.route,
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { transitionLength },
                    animationSpec = slideTransitionSpec
                ) + fadeIn(fadeTransitionSpec)
            },
            exitTransition = {
                fadeOut(fadeTransitionSpec)
            }
        ) {
            AccountSelection(navController = navController)
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
            RegisterCompany(navController = navController)
        }
    }
}