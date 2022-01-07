package com.example.sessions_clean.android.ui.screens.bottom_sheets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sessions_clean.android.ui.components.Button
import com.example.sessions_clean.android.ui.theme.ExtendedTheme
import com.example.sessions_clean.android.ui.theme.Spacing

@Composable
fun ProfileImageSelectAction() {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(Spacing.l),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                Icons.Outlined.Image,
                contentDescription = "choose photo",
                tint = ExtendedTheme.orange
            )
            Spacer(modifier = Modifier.width(Spacing.l))
            Text("Photos", style = MaterialTheme.typography.titleMedium)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(Spacing.l),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                Icons.Outlined.CameraAlt,
                contentDescription = "take photo",
                tint = ExtendedTheme.green,
            )
            Spacer(modifier = Modifier.width(Spacing.l))
            Text("Camera", style = MaterialTheme.typography.titleMedium)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(Spacing.l),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                Icons.Outlined.DeleteOutline,
                contentDescription = "take photo",
                tint = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.width(Spacing.l))
            Text("Remove Photo", style = MaterialTheme.typography.titleMedium)

        }
    }
}