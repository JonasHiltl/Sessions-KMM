package com.example.sessions.android.ui.screens.auth.person

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
import com.example.sessions.android.ui.components.ProfileImage
import com.example.sessions.android.ui.annimations.SlideFromLeftTransition
import com.example.sessions.android.ui.screens.destinations.LoginScreenDestination
import com.example.sessions.android.ui.theme.Spacing
import com.example.sessions.presentation.auth.register.RegisterEvents
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Destination(navGraph = Constants.AUTH_NAV_GRAPH, style = SlideFromLeftTransition::class)
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator,
    viewModel: RegisterViewModel = get()
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
                        onValueChange = {
                            viewModel.onTriggerEvent(
                                RegisterEvents.OnUpdateUsername(
                                    it
                                )
                            )
                        },
                        placeholder = "Username",
                        expand = true,
                        modifier = Modifier.padding(bottom = Spacing.m),
                    )
                    Row() {
                        CustomTextField(
                            value = state.firstname,
                            onValueChange = {
                                viewModel.onTriggerEvent(
                                    RegisterEvents.OnUpdateFirstname(
                                        it
                                    )
                                )
                            },
                            placeholder = "First Name",
                            expand = true,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = Spacing.m)
                        )
                        CustomTextField(
                            value = state.lastname,
                            onValueChange = {
                                viewModel.onTriggerEvent(
                                    RegisterEvents.OnUpdateLastname(
                                        it
                                    )
                                )
                            },
                            placeholder = "Last Name",
                            expand = true,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                    CustomTextField(
                        value = state.email,
                        onValueChange = { viewModel.onTriggerEvent(RegisterEvents.OnUpdateEmail(it)) },
                        placeholder = "Email",
                        expand = true,
                        modifier = Modifier.padding(top = Spacing.m),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )
                }
                Column() {
                    Button(
                        text = "Register",
                        onClick = { viewModel.onTriggerEvent(RegisterEvents.Register) },
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
                        Text("Joined Before?", style = MaterialTheme.typography.bodyMedium)
                        Button(
                            text = "Login",
                            onClick = {
                                navigator.navigate(LoginScreenDestination)
                            },
                            textButton = true
                        )
                    }
                }
            }
        }
    }
}