package com.example.sessions_clean.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val lightColorTheme = lightColorScheme(
    primary = primary,
)

private val darkColorTheme = darkColorScheme(
    primary = primary,
)

@Composable
fun M3Themee(
    darkTheme: Boolean? = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme == true) darkColorTheme else lightColorTheme,
        content = content
    )
}