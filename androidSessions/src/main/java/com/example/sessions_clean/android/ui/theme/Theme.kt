package com.example.sessions_clean.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightColorTheme = lightColorScheme(
    primary = primaryDark,
    background = LightColors.background,
    surface = LightColors.surface,
    error = errorColor
)

private val darkColorTheme = darkColorScheme(
    primary = primaryDark,
    background = DarkColors.background,
    surface = DarkColors.surface,
    error = errorColor
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

object ExtendedTheme {
    val placeHolder: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.placeholder else LightColors.placeholder
    val orange: Color
        @Composable
        get() = Color(0xFBFC9F3B)
    val green: Color
        @Composable
        get() = Color(0xFF58C95D)
    val errorNotificationBG: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.errorNotificationBG else LightColors.errorNotificationBG
    val errorNotificationBorder: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.errorNotificationBorder else LightColors.errorNotificationBorder
    val successNotificationBG: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.successNotificationBG else LightColors.successNotificationBG
    val successNotificationBorder: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.successNotificationBorder else LightColors.successNotificationBorder
    val success: Color
        @Composable
        get() = successColor
    val disableButtonBG: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.disableButtonBG else LightColors.disableButtonBG
    val disableButtonBorder: Color
        @Composable
        get() = if (isSystemInDarkTheme()) DarkColors.disableButtonBorder else LightColors.disableButtonBorder
}