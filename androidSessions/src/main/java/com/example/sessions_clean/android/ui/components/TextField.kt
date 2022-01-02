package com.example.sessions_clean.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Placeholder
import com.example.sessions_clean.android.ui.theme.Spacing

@Composable
fun TextField(
    modifier: Modifier? = Modifier,
    placeholder: String? = null,
    expand: Boolean? = false,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    Box(modifier = modifier ?: Modifier) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(Spacing.m))
                .background(MaterialTheme.colorScheme.surface)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            Box(
                modifier =
                if (expand == false)
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
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    modifier = if (expand == false) Modifier else Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyLarge
                )
                if (value.text.isEmpty() and (placeholder != null)) {
                    Text(
                        placeholder!!,
                        color = MaterialTheme.typography.bodyMedium.color.copy(alpha = 0.25f),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                }
            }
            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}