package com.example.sessions_clean.android.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sessions_clean.android.ui.theme.Spacing

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textButton: Boolean = false,
) {
    if (!textButton) {
        androidx.compose.material3.Button(
            modifier = modifier,
            onClick = onClick,
            enabled = enabled,
            shape = RoundedCornerShape(Spacing.m),
            contentPadding = PaddingValues(vertical = 18.dp, horizontal = 30.dp),
        ) {
            Text(
                text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )
        }
    } else {
        TextButton(
            modifier = Modifier
                .defaultMinSize(minHeight = 1.dp)
                .then(modifier),
            onClick = onClick,
            enabled = enabled,
            shape = RoundedCornerShape(Spacing.m),
            contentPadding = PaddingValues(vertical = 6.dp, horizontal = 8.dp),
        ) {
            Text(
                text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}