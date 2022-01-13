package com.example.sessions_clean.android.helpers

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.IntOffset

object Constants {
    const val transitionLength = 300
    val slideTransitionSpec: FiniteAnimationSpec<IntOffset> =
        tween(transitionLength, easing = FastOutSlowInEasing)

    val fadeTransitionSpec: FiniteAnimationSpec<Float> =
        tween(transitionLength, easing = FastOutSlowInEasing)

    const val AUTH_NAV_GRAPH = "auth"
}