package com.example.sessions.android.ui.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp
import com.example.sessions.android.ui.components.StatusBarInset
import com.example.sessions.android.ui.annimations.FadeInOutTransition
import com.example.sessions.android.ui.screens.home.components.AppBar
import com.example.sessions.android.ui.theme.ExtendedTheme
import com.example.sessions.android.ui.theme.Spacing
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
)
@Destination(start = true, style = FadeInOutTransition::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    fun toggleSheet() {
        coroutineScope.launch {
            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                bottomSheetScaffoldState.bottomSheetState.expand()
            } else {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        }
    }

    fun Modifier.toggleSheet(bottomSheetState: BottomSheetState) = composed(
        inspectorInfo = debugInspectorInfo {
            name = "toggleSheetModifier"
            value = bottomSheetState
        }, {
            if (bottomSheetState.isExpanded) {
                pointerInput(Unit) {
                    detectTapGestures(onTap = { toggleSheet() })
                }
            } else fillMaxHeight()
        }
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    Modifier
                        .padding(Spacing.m)
                        .width(50.dp)
                        .height(5.dp)
                        .clip(CircleShape)
                        .background(ExtendedTheme.placeHolder)
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = { toggleSheet() })
                        }
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                ) {

                }
            }
        },
        sheetShape = RoundedCornerShape(
            topStart = Spacing.l,
            topEnd = Spacing.l
        ),
        sheetPeekHeight = LocalConfiguration.current.screenHeightDp.dp * 0.15f,
        sheetBackgroundColor = MaterialTheme.colorScheme.surface,
    ) {
        Scaffold(
            modifier = Modifier.toggleSheet(bottomSheetScaffoldState.bottomSheetState),
        ) {
            StatusBarInset {
                Box {
                    AppBar()
                }
            }
        }
    }
}