package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.screens.auth.AccountSelectionScreen
import com.example.sessions_clean.android.ui.screens.auth.company.RegisterCompanyScreen
import com.example.sessions_clean.android.ui.screens.auth.login.LoginScreen
import com.example.sessions_clean.android.ui.screens.auth.login.LoginViewModel
import com.example.sessions_clean.android.ui.screens.auth.person.RegisterScreen
import com.example.sessions_clean.android.ui.screens.auth.person.RegisterViewModel
import com.example.sessions_clean.android.ui.theme.Constants
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.getViewModel


@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.authNavGraph() {
    navigation(
        startDestination = Screen.AccountSelection.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(
            Screen.Login.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
        ) {
            val loginViewModel: LoginViewModel = getViewModel()

            LoginScreen(
                state = loginViewModel.state.value,
                onTriggerEvent = loginViewModel::onTriggerEvent
            )
        }
        composable(
            Screen.Register.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -Constants.transitionLength },
                    animationSpec = Constants.slideTransitionSpec
                ) + fadeIn(Constants.fadeTransitionSpec)
            },
            exitTransition = { ExitTransition.None }
        ) {
            val registerViewModel: RegisterViewModel = getViewModel()
            RegisterScreen(
                state = registerViewModel.state.value,
                onTriggerEvent = registerViewModel::onTriggerEvent
            )
        }
        composable(
            Screen.AccountSelection.route,
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { Constants.transitionLength },
                    animationSpec = Constants.slideTransitionSpec
                ) + fadeIn(Constants.fadeTransitionSpec)
            },
            exitTransition = {
                fadeOut(Constants.fadeTransitionSpec)
            }
        ) {
            AccountSelectionScreen()
        }
        composable(
            Screen.RegisterCompany.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { Constants.transitionLength },
                    animationSpec = Constants.slideTransitionSpec
                ) + fadeIn(Constants.fadeTransitionSpec)
            },
            exitTransition = { ExitTransition.None }
        ) {
            RegisterCompanyScreen()
        }
    }
}