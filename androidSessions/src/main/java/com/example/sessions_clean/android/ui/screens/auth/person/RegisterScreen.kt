package com.example.sessions_clean.android.ui.screens.auth.person

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.navigation.NavController
import com.example.sessions_clean.android.ui.components.Button
import com.example.sessions_clean.android.ui.components.CustomTextField
import com.example.sessions_clean.android.ui.components.ProfileImage
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.theme.Spacing
import com.example.sessions_clean.presentation.auth.register.RegisterEvents
import com.example.sessions_clean.presentation.auth.register.RegisterState

@Composable
fun RegisterScreen(
    navController: NavController,
    state: RegisterState,
    onTriggerEvent: (RegisterEvents) -> Unit
) {
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
            ProfileImage()
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
                    "Register",
                    modifier = Modifier.padding(bottom = 20.dp),
                    style = MaterialTheme.typography.headlineLarge,
                )
                CustomTextField(
                    value = state.username,
                    onValueChange = { onTriggerEvent(RegisterEvents.OnUpdateUsername(it)) },
                    placeholder = "Username",
                    expand = true,
                    modifier = Modifier.padding(bottom = Spacing.m),
                )
                Row() {
                    CustomTextField(
                        value = state.firstname,
                        onValueChange = { onTriggerEvent(RegisterEvents.OnUpdateFirstname(it)) },
                        placeholder = "First Name",
                        expand = true,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = Spacing.m)
                    )
                    CustomTextField(
                        value = state.lastname,
                        onValueChange = { onTriggerEvent(RegisterEvents.OnUpdateLastname(it)) },
                        placeholder = "Last Name",
                        expand = true,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                CustomTextField(
                    value = state.email,
                    onValueChange = { onTriggerEvent(RegisterEvents.OnUpdateEmail(it)) },
                    placeholder = "Email",
                    expand = true,
                    modifier = Modifier.padding(top = Spacing.m),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )
            }
            Column() {
                Button(
                    text = "Register",
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = Spacing.s),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Joined Before?", style = MaterialTheme.typography.bodyMedium)
                    Button(
                        text = "Login",
                        onClick = {
                            navController.navigate(Screen.Login.route)
                        },
                        textButton = true
                    )
                }
            }
        }
    }

}