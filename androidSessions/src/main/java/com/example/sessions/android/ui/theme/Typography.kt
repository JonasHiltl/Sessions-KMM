package com.example.sessions.android.ui.theme

import androidx.compose.material3.Typography

val lightTypography: Typography = Typography()

val darkTypography: Typography = Typography(
    displayLarge = lightTypography.displayLarge.copy(color = darkColorTheme.onBackground),
    displayMedium = lightTypography.displayMedium.copy(color = darkColorTheme.onBackground),
    displaySmall = lightTypography.displaySmall.copy(color = darkColorTheme.onBackground),
    headlineLarge = lightTypography.headlineLarge.copy(color = darkColorTheme.onBackground),
    headlineMedium = lightTypography.headlineMedium.copy(color = darkColorTheme.onBackground),
    headlineSmall = lightTypography.headlineSmall.copy(color = darkColorTheme.onBackground),
    titleLarge = lightTypography.titleLarge.copy(color = darkColorTheme.onBackground),
    titleMedium = lightTypography.titleMedium.copy(color = darkColorTheme.onBackground),
    titleSmall = lightTypography.titleSmall.copy(color = darkColorTheme.onBackground),
    bodyLarge = lightTypography.bodyLarge.copy(color = darkColorTheme.onBackground),
    bodyMedium = lightTypography.bodyMedium.copy(color = darkColorTheme.onBackground),
    bodySmall = lightTypography.bodySmall.copy(color = darkColorTheme.onBackground),
    labelLarge = lightTypography.labelLarge.copy(color = darkColorTheme.onBackground),
    labelMedium = lightTypography.labelMedium.copy(color = darkColorTheme.onBackground),
    labelSmall = lightTypography.labelSmall.copy(color = darkColorTheme.onBackground),
)