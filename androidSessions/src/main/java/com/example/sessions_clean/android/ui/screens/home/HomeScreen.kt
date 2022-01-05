package com.example.sessions_clean.android.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sessions_clean.android.ui.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column() {
        Text(
            "Home Screen",
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Button(onClick = {
            navController.navigate(Screen.Login.route)
        }) {
            Text("Login")
        }
        Button(onClick = {
            navController.navigate(Screen.Register.route)
        }) {
            Text("Register")
        }
    }
}