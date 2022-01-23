package com.example.sessions.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sessions.android.ui.theme.ExtendedTheme
import com.example.sessions.android.ui.theme.Spacing

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    textButton: Boolean = false,
) {
    if (!textButton) {
        androidx.compose.material3.Button(
            modifier = modifier,
            onClick = onClick,
            enabled = !isLoading,
            shape = RoundedCornerShape(Spacing.m),
            contentPadding = PaddingValues(vertical = 18.dp, horizontal = 30.dp),
            border = BorderStroke(
                1.dp,
                if (isLoading) ExtendedTheme.disableButtonBorder else MaterialTheme.colorScheme.primary
            ),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = ExtendedTheme.disableButtonBG
            )
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 3.dp
                )
            } else
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
            if (isLoading) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 3.dp
                )
            } else
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