package com.example.sessions.android.ui.annimations

import androidx.compose.animation.*
import androidx.navigation.NavBackStackEntry
import com.example.sessions.android.helpers.Constants
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(
    ExperimentalAnimationApi::class,
)
object FadeInOutTransition : DestinationStyle.Animated {
    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return fadeIn(Constants.fadeTransitionSpec)
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return fadeOut(Constants.fadeTransitionSpec)
    }
}