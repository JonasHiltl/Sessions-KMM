package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.sessions_clean.android.localNavController
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.ROOT_GRAPH_ROUTE
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
) {
    val navController = localNavController.current
    AnimatedNavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        homeNavGraph()
        authNavGraph()
    }
}