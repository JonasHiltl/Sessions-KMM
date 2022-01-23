package com.example.sessions.android.ui.screens.auth.company

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sessions.android.helpers.Constants
import com.example.sessions.android.ui.annimations.SlideFromRightTransition
import com.example.sessions.android.ui.screens.destinations.AccountSelectionScreenDestination
import com.example.sessions.android.ui.screens.destinations.LoginScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Destination(navGraph = Constants.AUTH_NAV_GRAPH, style = SlideFromRightTransition::class)
@Composable
fun RegisterCompanyScreen(
    navigator: DestinationsNavigator,
) {
    Scaffold() {
        Text(
            "Register Bar & Club",
            modifier = Modifier.clickable {
                navigator.navigate(LoginScreenDestination)
            },
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Button(onClick = {
            navigator.navigate(AccountSelectionScreenDestination)
        }) {
            Text("Choose account")
        }
    }
}