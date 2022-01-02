package com.example.sessions_clean.android.ui.screens.auth.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sessions_clean.android.ui.navigation.AUTH_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.HOME_GRAPH_ROUTE
import com.example.sessions_clean.android.ui.navigation.Screen

@Composable
fun RegisterScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Register",
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Login.route)
            },
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Button(onClick = {
            navController.navigate(Screen.AccountSelection.route)
        }) {
            Text("Choose account")
        }
    }

}