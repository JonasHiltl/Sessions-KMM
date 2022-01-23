package com.example.sessions.android.ui.screens.home.profile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sessions.android.ui.components.StatusBarInset
import com.example.sessions.android.ui.components.backgrounds.Background2
import com.example.sessions.android.ui.annimations.FadeInOutTransition
import com.example.sessions.android.ui.theme.Spacing
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
)
@Destination(style = FadeInOutTransition::class)
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {
    Scaffold {
        Background2()
        StatusBarInset {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.m, vertical = Spacing.s),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    navigator.popBackStack()
                }) {
                    Icon(
                        Icons.Rounded.Close,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "Close Profile screen",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}