package com.example.sessions.android.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.sessions.android.localNavController
import com.example.sessions.android.ui.screens.destinations.ProfileImageSelectActionDestination
import com.example.sessions.android.ui.theme.ExtendedTheme
import com.ramcosta.composedestinations.navigation.navigateTo

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ProfileImage() {
    val navController = localNavController.current

    Box(
        modifier = Modifier
            .width(120.dp)
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
            .combinedClickable(
                onClick = { navController.navigateTo(ProfileImageSelectActionDestination) },
                onLongClick = { navController.navigateTo(ProfileImageSelectActionDestination) },
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            Icons.Rounded.CameraAlt,
            contentDescription = "Camera",
            tint = ExtendedTheme.placeHolder
        )
    }

}