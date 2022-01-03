package com.example.sessions_clean.android.ui.screens.auth.person

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.sessions_clean.android.ui.components.ProfileImage
import com.example.sessions_clean.android.ui.components.TextField
import com.example.sessions_clean.android.ui.theme.Spacing

@Preview(showBackground = true)
@Composable
fun RegisterScreen(

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
                        MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f),
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
                .padding(Spacing.m)
        ) {
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
    }

}