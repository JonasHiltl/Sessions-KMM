package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.screens.auth.LoginScreen
import com.example.sessions_clean.android.ui.screens.auth.RegisterScreen
import com.example.sessions_clean.android.ui.screens.auth.AccountSelectionScreen

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
            Screen.Register.route
        ) {
            RegisterScreen(navController = navController)
        }
        composable(
            Screen.AccountSelection.route
        ) {
            AccountSelectionScreen()
        }
    }
}