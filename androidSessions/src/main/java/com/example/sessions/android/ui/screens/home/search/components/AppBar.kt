package com.example.sessions.android.ui.screens.home.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sessions.android.localNavController
import com.example.sessions.android.ui.components.Input
import com.example.sessions.android.ui.theme.Spacing

@Composable
fun AppBar(
    query: String,
    onUpdateQuery: (String) -> Unit
) {
    val navController = localNavController.current

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.m, vertical = Spacing.s),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Input(
            value = query,
            onValueChange = onUpdateQuery,
            expand = true,
            placeholder = "search",
            leadingIcon = {
                Icon(
                    Icons.Outlined.Search, contentDescription = "Search Icon"
                )
            }
        )
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                Icons.Rounded.Close,
                modifier = Modifier.size(30.dp),
                contentDescription = "Close Search screen",
                tint = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}