package com.example.sessions_clean.android.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.sessions_clean.android.localNavController
import com.example.sessions_clean.android.ui.components.StatusBarInset
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.theme.Spacing
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen() {
    val navController = localNavController.current
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
            ) {
                Text("Hello from Sheet")
            }
        },
        sheetShape = RoundedCornerShape(
            topStart = Spacing.l,
            topEnd = Spacing.l
        ),
        sheetPeekHeight = LocalConfiguration.current.screenHeightDp.dp * 0.15f,
        sheetBackgroundColor = MaterialTheme.colorScheme.surface,
    ) {
        androidx.compose.material3.Scaffold(
            topBar = {
                StatusBarInset {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Spacing.m, vertical = Spacing.s),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = { navController.navigate(Screen.Profile.route) }) {
                            Icon(
                                Icons.Rounded.Menu,
                                modifier = Modifier.size(30.dp),
                                contentDescription = "Menu",
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Rounded.Search,
                                modifier = Modifier.size(30.dp),
                                contentDescription = "Menu",
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                }
            }
        ) {
            androidx.compose.material3.Button(
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                },
            ) {
                Text("Toggle Sheet")
            }
        }
    }
}