package com.example.sessions.android.ui.screens.auth.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.sessions.android.helpers.Constants
import com.example.sessions.android.ui.components.Button
import com.example.sessions.android.ui.components.CustomTextField
import com.example.sessions.android.ui.annimations.NoTransition
import com.example.sessions.android.ui.screens.destinations.AccountSelectionScreenDestination
import com.example.sessions.android.ui.theme.Spacing
import com.example.sessions.presentation.auth.login.LoginEvents
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Destination(navGraph = Constants.AUTH_NAV_GRAPH, style = NoTransition::class)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = get(),
) {
    val state = viewModel.state.value
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
                        onValueChange = {
                            viewModel.onTriggerEvent(
                                LoginEvents.OnUpdateUsernameOrEmail(
                                    it
                                )
                            )
                        },
                        placeholder = "Username or Email",
                        expand = true,
                        modifier = Modifier.padding(bottom = Spacing.m),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    CustomTextField(
                        value = state.password,
                        onValueChange = {
                            viewModel.onTriggerEvent(
                                LoginEvents.OnUpdatePassword(
                                    it
                                )
                            )
                        },
                        placeholder = "Password",
                        expand = true,
                        isPasswordField = true,
                    )
                }
                Column() {
                    Button(
                        text = "Login",
                        onClick = { viewModel.onTriggerEvent(LoginEvents.Login) },
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
                                navigator.navigate(AccountSelectionScreenDestination)
                            },
                            textButton = true
                        )
                    }
                }
            }
        }
    }
}