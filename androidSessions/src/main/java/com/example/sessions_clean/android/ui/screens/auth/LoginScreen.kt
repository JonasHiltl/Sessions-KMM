package com.example.sessions_clean.android.ui.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.sessions_clean.android.ui.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavController
) {
    Text(
        "login",
        modifier = Modifier.clickable {
            navController.navigate(route = Screen.Register.route)
        },
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
}