package com.example.sessions.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val lightColorTheme = lightColorScheme(
    primary = primaryDark,
    background = LightColors.background,
    surface = LightColors.surface,
    error = errorColor
)

val darkColorTheme = darkColorScheme(
    primary = primaryDark,
    background = DarkColors.background,
    surface = DarkColors.surface,
    error = errorColor
)

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

@Composable
fun M3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
    }

    CompositionLocalProvider(LocalDarkMode provides darkTheme) {
        MaterialTheme(
            colorScheme = if (darkTheme) darkColorTheme else lightColorTheme,
            typography = if (darkTheme) darkTypography else lightTypography,
            content = content
        )
    }
}
