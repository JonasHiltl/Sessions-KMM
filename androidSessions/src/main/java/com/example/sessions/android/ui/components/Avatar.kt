package com.example.sessions.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.sessions.android.ui.screens.destinations.ProfileImageSelectActionDestination
import com.example.sessions.android.ui.theme.ExtendedTheme
import com.example.sessions.android.ui.theme.Spacing
import com.example.sessions.model.Profile
import com.ramcosta.composedestinations.navigation.navigateTo

enum class Size {
    SMALL, MEDIUM, LARGE
}

@Composable
fun Avatar(
    size: Size = Size.SMALL,
    profile: Profile
) {
    Box(
        modifier = Modifier
            .width(
                when (size) {
                    Size.SMALL -> 50.dp
                    Size.MEDIUM -> 80.dp
                    Size.LARGE -> 120.dp
                }
            )
            .aspectRatio(1f)
            .clip(RoundedCornerShape(Spacing.m))
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        if (profile.picture?.isNotEmpty() == true) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberImagePainter(data = profile.picture),
                contentDescription = "Profile Image"
            )
        } else {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text("${profile.firstname.first()}")
                Text("${profile.lastname?.first()}")
            }
        }
    }
}