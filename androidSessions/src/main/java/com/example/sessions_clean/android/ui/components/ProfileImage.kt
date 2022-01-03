package com.example.sessions_clean.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sessions_clean.android.ui.theme.ExtendedTheme

@Composable
fun ProfileImage() {
    Box(
        modifier = Modifier
            .width(120.dp)
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            Icons.Rounded.CameraAlt,
            contentDescription = "Camera",
            tint = ExtendedTheme.placeHolder
        )
    }
}