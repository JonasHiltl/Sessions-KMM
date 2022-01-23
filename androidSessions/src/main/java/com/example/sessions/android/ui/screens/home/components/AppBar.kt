package com.example.sessions.android.ui.screens.home.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.sessions.android.localNavController
import com.example.sessions.android.ui.screens.destinations.ProfileScreenDestination
import com.example.sessions.android.ui.theme.Spacing
import com.ramcosta.composedestinations.navigation.navigateTo

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun AppBar() {
    val navController = localNavController.current

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.m, vertical = Spacing.s)
            .zIndex(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.navigateTo(ProfileScreenDestination) }) {
            Icon(
                Icons.Rounded.Menu,
                modifier = Modifier.size(30.dp),
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        IconButton(onClick = { }) {
            Icon(
                Icons.Rounded.Search,
                modifier = Modifier.size(30.dp),
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}