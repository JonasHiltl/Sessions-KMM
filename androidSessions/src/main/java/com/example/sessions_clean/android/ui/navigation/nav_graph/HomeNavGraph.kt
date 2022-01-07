package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.sessions_clean.android.ui.navigation.HOME_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.screens.home.HomeScreen
import com.google.accompanist.navigation.animation.composable

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
fun NavGraphBuilder.homeNavGraph() {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            Screen.Home.route
        ) {
            HomeScreen()
        }
    }
}