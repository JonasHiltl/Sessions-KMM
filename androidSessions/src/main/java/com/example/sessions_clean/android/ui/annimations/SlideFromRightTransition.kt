package com.example.sessions_clean.android.ui.annimations

import androidx.compose.animation.*
import androidx.navigation.NavBackStackEntry
import com.example.sessions_clean.android.helpers.Constants
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(
    ExperimentalAnimationApi::class,
)
object SlideFromRightTransition : DestinationStyle.Animated {
    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return slideInHorizontally(
            initialOffsetX = { Constants.transitionLength },
            animationSpec = Constants.slideTransitionSpec
        ) + fadeIn(Constants.fadeTransitionSpec)
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return ExitTransition.None
    }
}