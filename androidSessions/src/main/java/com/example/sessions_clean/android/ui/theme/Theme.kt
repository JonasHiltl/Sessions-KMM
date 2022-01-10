package com.example.sessions_clean.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalDarkMode provides darkTheme) {
        MaterialTheme(
            colorScheme = if (darkTheme == true) darkColorTheme else lightColorTheme,
            content = content
        )
    }
}

val LocalDarkMode = compositionLocalOf<Boolean> {
    error("No context provided")
}

object ExtendedTheme {
    val placeHolder: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.placeholder else LightColors.placeholder
    val orange: Color
        @Composable
        get() = Color(0xFBFC9F3B)
    val green: Color
        @Composable
        get() = Color(0xFF58C95D)
    val errorNotificationBG: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.errorNotificationBG else LightColors.errorNotificationBG
    val errorNotificationBorder: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.errorNotificationBorder else LightColors.errorNotificationBorder
    val successNotificationBG: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.successNotificationBG else LightColors.successNotificationBG
    val successNotificationBorder: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.successNotificationBorder else LightColors.successNotificationBorder
    val success: Color
        @Composable
        get() = successColor
    val disableButtonBG: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.disableButtonBG else LightColors.disableButtonBG
    val disableButtonBorder: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.disableButtonBorder else LightColors.disableButtonBorder
    val backgroundPurple: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.backgroundPurple else LightColors.backgroundPurple
    val backgroundBlue: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.backgroundBlue else LightColors.backgroundBlue
    val backgroundLightBlue: Color
        @Composable
        get() = if (LocalDarkMode.current) DarkColors.backgroundLightBlue else LightColors.backgroundLightBlue
}