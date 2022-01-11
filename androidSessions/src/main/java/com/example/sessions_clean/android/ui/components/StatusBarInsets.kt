package com.example.sessions_clean.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun StatusBarInset(
    content: @Composable () -> Unit,
) {
    Column {
        Spacer(modifier = Modifier
            .statusBarsHeight()
            .fillMaxWidth())
        content()
    }
}