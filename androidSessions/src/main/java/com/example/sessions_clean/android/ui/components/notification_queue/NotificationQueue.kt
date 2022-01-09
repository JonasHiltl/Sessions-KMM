package com.example.sessions_clean.android.ui.components.notification_queue

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sessions_clean.android.ui.theme.Spacing

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun NotificationQueue(
    state: NotificationQueueState,
    content: @Composable () -> Unit,
) {
    val snackState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = state.queue.size, block = {
        if (!state.queue.isEmpty()) {
            snackState.showSnackbar(
                message = state.queue.first().message,
                duration = SnackbarDuration.Short,
                actionLabel = "Done"
            )
        }
    })

    Box {
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            SnackbarHost(
                hostState = snackState,
                snackbar = { snackbarData ->
                    Snackbar(
                        snackbarData,
                        shape = RoundedCornerShape(Spacing.m)
                    )
                }
            )
        }
    }
}