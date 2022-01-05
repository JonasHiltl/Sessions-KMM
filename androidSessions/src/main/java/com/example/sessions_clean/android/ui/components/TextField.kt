package com.example.sessions_clean.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.sessions_clean.android.ui.theme.ExtendedTheme
import com.example.sessions_clean.android.ui.theme.Spacing

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    expand: Boolean = false,
    value: String,
    isPasswordField: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (TextFieldValue) -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Box(modifier = modifier ?: Modifier) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(Spacing.m))
                .background(MaterialTheme.colorScheme.surface),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            Box(
                modifier =
                if (!expand)
                    Modifier
                        .padding(
                            start = if (leadingIcon != null) Spacing.m else 0.dp,
                            end = if (trailingIcon != null) Spacing.m else 0.dp
                        )
                else Modifier
                    .weight(1f)
                    .padding(
                        start = if (leadingIcon != null) Spacing.m else 0.dp,
                        end = if (trailingIcon != null) Spacing.m else 0.dp
                    )
            ) {
                BasicTextField(
                    value = TextFieldValue(text = value),
                    onValueChange = onValueChange,
                    singleLine = true,
                    modifier = Modifier
                        .padding(12.dp)
                        .then(if (!expand) Modifier else Modifier.fillMaxWidth()),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    keyboardOptions = if (isPasswordField)
                        KeyboardOptions(keyboardType = KeyboardType.Password)
                    else
                        keyboardOptions,
                    visualTransformation =
                    if (isPasswordField and passwordVisible)
                        VisualTransformation.None
                    else if (isPasswordField and !passwordVisible)
                        PasswordVisualTransformation()
                    else
                        visualTransformation
                )
                if (value.isEmpty() and (placeholder != null)) {
                    Text(
                        placeholder!!,
                        color = ExtendedTheme.placeHolder,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        modifier = Modifier.padding(12.dp),
                    )
                }
            }
            if (trailingIcon != null) {
                trailingIcon()
            }
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
            }
        }
    }
}