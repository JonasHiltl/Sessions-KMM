package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.sessions_clean.android.ui.navigation.HOME_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.screens.home.HomeScreen
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
    }
}