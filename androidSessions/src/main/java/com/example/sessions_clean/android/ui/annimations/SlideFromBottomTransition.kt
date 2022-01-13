package com.example.sessions_clean.android.ui.annimations

import androidx.compose.animation.*
import androidx.navigation.NavBackStackEntry
import com.example.sessions_clean.android.helpers.Constants
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(
    ExperimentalAnimationApi::class,
)
object SlideFromBottomTransition : DestinationStyle.Animated {
    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return slideInVertically(
            initialOffsetY = { Constants.transitionLength },
            animationSpec = Constants.slideTransitionSpec
        ) + fadeIn(Constants.fadeTransitionSpec)
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return fadeOut(Constants.fadeTransitionSpec)
    }
}