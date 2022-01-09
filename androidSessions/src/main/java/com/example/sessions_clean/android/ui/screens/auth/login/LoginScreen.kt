package com.example.sessions_clean.android.ui.screens.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.sessions_clean.android.localNavController
import com.example.sessions_clean.android.ui.components.Button
import com.example.sessions_clean.android.ui.components.CustomTextField
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.theme.Spacing
import com.example.sessions_clean.presentation.auth.login.LoginEvents
import com.example.sessions_clean.presentation.auth.login.LoginState

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    state: LoginState,
    onTriggerEvent: (LoginEvents) -> Unit
) {
    val navController = localNavController.current

    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                        )
                    )
                ),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
            }
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = Spacing.l, topEnd = Spacing.l))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(Spacing.m),
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Login",
                        modifier = Modifier.padding(bottom = 20.dp),
                        style = MaterialTheme.typography.headlineLarge,
                    )
                    CustomTextField(
                        value = state.usernameOrEmail,
                        onValueChange = { onTriggerEvent(LoginEvents.OnUpdateUsernameOrEmail(it)) },
                        placeholder = "Username or Email",
                        expand = true,
                        modifier = Modifier.padding(bottom = Spacing.m),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    CustomTextField(
                        value = state.password,
                        onValueChange = { onTriggerEvent(LoginEvents.OnUpdatePassword(it)) },
                        placeholder = "Password",
                        expand = true,
                        isPasswordField = true,
                    )
                }
                Column() {
                    Button(
                        text = "Login",
                        onClick = { onTriggerEvent(LoginEvents.Login) },
                        isLoading = state.isLoading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = Spacing.s),
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Not yet registered?", style = MaterialTheme.typography.bodyMedium)
                        Button(
                            text = "Register",
                            onClick = {
                                navController.navigate(Screen.AccountSelection.route)
                            },
                            textButton = true
                        )
                    }
                }
            }
        }
    }
}