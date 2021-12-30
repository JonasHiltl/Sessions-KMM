package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.screens.auth.LoginScreen
import com.example.sessions_clean.android.ui.screens.auth.RegisterScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.Login.route,
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
    }
}