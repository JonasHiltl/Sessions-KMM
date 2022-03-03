package com.example.sessions.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.unit.dp
import com.example.sessions.android.ui.theme.ExtendedTheme
import com.example.sessions.android.ui.theme.Spacing

@Composable
fun Input(
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

    Box(modifier) {
        BasicTextField(
            value = value,
            modifier = if (!expand) Modifier else Modifier.fillMaxWidth(),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            keyboardOptions = if (isPasswordField) {
                KeyboardOptions(keyboardType = KeyboardType.Password)
            } else {
                keyboardOptions
            },
            visualTransformation = if (isPasswordField and passwordVisible) {
                VisualTransformation.None
            } else if (isPasswordField and !passwordVisible) {
                PasswordVisualTransformation()
            } else {
                visualTransformation
            },
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .background(
                            MaterialTheme.colorScheme.surface,
                            RoundedCornerShape(Spacing.m)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (leadingIcon != null) {
                        Box(Modifier.padding(start = Spacing.m)) {
                            leadingIcon()
                        }
                    }
                    Box(
                        Modifier
                            .background(
                                MaterialTheme.colorScheme.surface,
                                RoundedCornerShape(Spacing.m)
                            )
                            .padding(Spacing.m)
                    ) {
                        if (value.isEmpty() && placeholder != null) {
                            Text(
                                placeholder,
                                style = MaterialTheme.typography.bodyLarge.copy(color = ExtendedTheme.placeHolder)
                            )
                        }
                        innerTextField()
                    }
                }
            },
        )
    }
}