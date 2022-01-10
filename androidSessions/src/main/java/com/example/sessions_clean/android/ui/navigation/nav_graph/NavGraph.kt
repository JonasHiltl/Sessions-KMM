package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.sessions_clean.android.localNavController
import com.example.sessions_clean.domain.global_state.AuthState
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.HOME_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.ROOT_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.providers.LocalAuthState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@ExperimentalMaterialNavigationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph() {
    val navController = localNavController.current
    val authState = LocalAuthState.current
    AnimatedNavHost(
        navController = navController,
        startDestination = if (authState.isAuthenticated == true) HOME_GRAPH_ROUTE else AUTH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        homeNavGraph()
        authNavGraph()
        bottomSheetNavGraph()
    }
}