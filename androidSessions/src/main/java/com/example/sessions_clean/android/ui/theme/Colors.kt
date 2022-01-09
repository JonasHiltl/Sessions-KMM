package com.example.sessions_clean.android.ui.theme

import androidx.compose.ui.graphics.Color

val primaryDark = Color(0xFF282C8A)
val primaryLight = Color(0xFF6A4EE6)

val gradientPurple = Color(0xFF642B73)
val gradientPink = Color(0xFFB942C6)

val successColor = Color(0xFF4CAF50)
val errorColor = Color(0xFFF44336)

object DarkColors {
    val background = Color(0xFF0F0F11)
    val surface = Color(0xFF171718)
    val placeholder = Color.White.copy(alpha = 0.25f)
    val errorNotificationBG = Color(0xFF4A1717)
    val errorNotificationBorder = Color(0xFF6F201D)
    val successNotificationBG = Color(0xFF18381E)
    val successNotificationBorder = Color(0xFF235129)
    val disableButtonBG = Color(256, 256, 256, 10)
    val disableButtonBorder = Color(256, 256, 256, 25)
}

object LightColors {
    val background = Color(0xFFF7FbFF)
    val surface = Color(0xFFF1F3FD)
    val placeholder = Color.Black.copy(alpha = 0.3f)
    val errorNotificationBG = Color(0xFFFFE4E4)
    val errorNotificationBorder = Color(0xFFF6BBB9)
    val successNotificationBG = Color(0xFFDCF8E7)
    val successNotificationBorder = Color(0xFFBBE0C2)
    val disableButtonBG = Color(48, 55, 121, 25)
    val disableButtonBorder = Color(0xFFD9D9D9)
}