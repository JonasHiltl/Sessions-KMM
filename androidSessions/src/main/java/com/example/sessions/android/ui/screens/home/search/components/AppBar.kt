package com.example.sessions.android.ui.screens.home.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sessions.android.localNavController
import com.example.sessions.android.ui.components.CustomTextField
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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicTextField(value = query, onValueChange = onUpdateQuery)
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                Icons.Rounded.Close,
                modifier = Modifier.size(30.dp),
                contentDescription = "Close Search screen",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}