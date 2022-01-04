package com.example.sessions_clean.android.ui.screens.auth.person

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sessions_clean.android.ui.components.Button
import com.example.sessions_clean.android.ui.components.ProfileImage
import com.example.sessions_clean.android.ui.components.TextField
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.theme.Spacing

@Composable
fun Register(
    navController: NavController
) {
    val textState = remember {
        mutableStateOf(TextFieldValue())
    }
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
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    placeholder = "Username",
                    expand = true,
                    modifier = Modifier.padding(bottom = Spacing.m),
                )
                Row() {
                    TextField(
                        value = textState.value,
                        onValueChange = { textState.value = it },
                        placeholder = "First Name",
                        expand = true,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = Spacing.m)
                    )
                    TextField(
                        value = textState.value,
                        onValueChange = { textState.value = it },
                        placeholder = "Last Name",
                        expand = true,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
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