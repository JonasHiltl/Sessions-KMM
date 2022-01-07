package com.example.sessions_clean.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.sessions_clean.android.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ProfileImage() {
    //TODO: use accompanist navigation material to globally define bottom sheets
    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Button(text = "Camera", onClick = {}, textButton = true)
                Button(text = "Choose", onClick = {}, textButton = true)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .clickable { scope.launch { state.show() } },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Rounded.CameraAlt,
                contentDescription = "Camera",
                tint = ExtendedTheme.placeHolder
            )
        }
    }
}