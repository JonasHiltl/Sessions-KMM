package com.example.sessions_clean.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val lightColorTheme = lightColorScheme(
    primary = primaryDark,
    background = LightColors.background,
    surface = LightColors.surface
)

private val darkColorTheme = darkColorScheme(
    primary = primaryDark,
    background = DarkColors.background,
    surface = DarkColors.surface
)

@Composable
fun M3Theme(
    darkTheme: Boolean? = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme == true) darkColorTheme else lightColorTheme,
        content = content
    )
}