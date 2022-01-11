package com.example.sessions_clean.android.ui.screens.home.profile

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
import com.example.sessions_clean.android.localNavController
import com.example.sessions_clean.android.ui.components.StatusBarInset
import com.example.sessions_clean.android.ui.components.backgrounds.Background2
import com.example.sessions_clean.android.ui.theme.Spacing

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen() {
    val navController = localNavController.current

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
                    navController.popBackStack()
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