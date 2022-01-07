package com.example.sessions_clean.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.sessions_clean.android.ui.theme.ExtendedTheme
import com.example.sessions_clean.android.ui.theme.Spacing

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    expand: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    value: String,
    isPasswordField: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            placeholder = {
                if (placeholder != null) Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodyLarge.copy(color = ExtendedTheme.placeHolder)
                )
            },
            modifier = Modifier.then(if (!expand) Modifier else Modifier.fillMaxWidth()),
            isError = isError,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.primary,
            ),
            singleLine = true,
            shape = RoundedCornerShape(Spacing.m),
            textStyle = MaterialTheme.typography.bodyLarge,
            trailingIcon = {
                if (isPasswordField) {
                    val icon =
                        if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "Toggle password",
                            tint = ExtendedTheme.placeHolder
                        )
                    }
                } else {
                    trailingIcon?.invoke()
                }
            },
            leadingIcon = leadingIcon,
            keyboardOptions = if (isPasswordField) {
                KeyboardOptions(keyboardType = KeyboardType.Password)
            } else {
                keyboardOptions
            },
            visualTransformation =
            if (isPasswordField and passwordVisible) {
                VisualTransformation.None
            } else if (isPasswordField and !passwordVisible) {
                PasswordVisualTransformation()
            } else {
                visualTransformation
            }
        )
    }
}