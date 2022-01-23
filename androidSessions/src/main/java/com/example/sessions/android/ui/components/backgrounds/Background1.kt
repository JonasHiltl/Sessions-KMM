package com.example.sessions.android.ui.components.backgrounds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.sessions.android.ui.theme.ExtendedTheme

@Composable
fun Background1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .blur(80.dp)
            .zIndex(-1f)
    ) {
        Box(
            modifier = Modifier
                .alpha(0.3f)
                .fillMaxSize(0.15f)
                .align(Alignment.TopEnd)
                .rotate(130f)
                .background(ExtendedTheme.backgroundLightBlue)
        )
        Box(
            modifier = Modifier
                .alpha(0.2f)
                .fillMaxSize(0.6f)
                .align(Alignment.TopStart)
                .rotate(130f)
                .background(ExtendedTheme.backgroundPurple)
        ) {
            Box(
                modifier = Modifier
                    .alpha(1f)
                    .fillMaxSize(0.6f)
                    .aspectRatio(1f)
                    .align(Alignment.CenterEnd)
                    .background(ExtendedTheme.backgroundLightBlue)
            )
        }
        Box(
            modifier = Modifier
                .alpha(0.14f)
                .fillMaxWidth()
                .fillMaxHeight(0.17f)
                .align(Alignment.TopEnd)
                .rotate(50f)
                .background(ExtendedTheme.backgroundPurple)
        )
        Box(
            modifier = Modifier
                .alpha(0.2f)
                .fillMaxSize(0.4f)
                .align(Alignment.CenterEnd)
                .rotate(45f)
                .background(ExtendedTheme.backgroundLightBlue)
        )
        Box(
            modifier = Modifier
                .alpha(0.15f)
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.2f)
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(40.dp))
                .rotate(150f)
                .background(ExtendedTheme.backgroundLightBlue)
        ) {
            Box(
                modifier = Modifier
                    .alpha(1f)
                    .fillMaxSize(0.6f)
                    .align(Alignment.CenterStart)
                    .clip(RoundedCornerShape(40.dp))
                    .rotate(0f)
                    .background(ExtendedTheme.backgroundPurple)
            )
        }
    }
}