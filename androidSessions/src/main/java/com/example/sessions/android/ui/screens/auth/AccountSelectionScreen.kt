package com.example.sessions.android.ui.screens.auth

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sessions.android.helpers.Constants
import com.example.sessions.android.ui.components.Button
import com.example.sessions.android.ui.components.StatusBarInset
import com.example.sessions.android.ui.components.backgrounds.Background1
import com.example.sessions.android.ui.annimations.SlideFromBottomTransition
import com.example.sessions.android.ui.screens.destinations.LoginScreenDestination
import com.example.sessions.android.ui.screens.destinations.RegisterCompanyScreenDestination
import com.example.sessions.android.ui.screens.destinations.RegisterScreenDestination
import com.example.sessions.android.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

private enum class AccountType {
    PERSON, COMPANY
}

private val animationSpec: FiniteAnimationSpec<Float> = tween(
    durationMillis = 200,
    easing = FastOutSlowInEasing
)

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Destination(
    navGraph = Constants.AUTH_NAV_GRAPH,
    start = true,
    style = SlideFromBottomTransition::class
)
@Composable
fun AccountSelectionScreen(
    navigator: DestinationsNavigator
) {
    val borderColor = MaterialTheme.colorScheme.onBackground.copy(
        alpha = 0.1f
    )
    val accountType = remember { mutableStateOf(AccountType.PERSON) }

    val personTransition = updateTransition(
        targetState = accountType.value,
        label = "Person Transition"
    )

    val companyTransition = updateTransition(
        targetState = accountType.value,
        label = "Company Transition",
    )

    val personBoxHeight by personTransition.animateFloat(
        label = "Person Box Height",
        transitionSpec = { animationSpec }
    ) { state ->
        when (state) {
            AccountType.PERSON -> 0.7f
            AccountType.COMPANY -> 0.6f
        }
    }

    val personBoxWeight by personTransition.animateFloat(
        label = "Person Box Weight",
        transitionSpec = { animationSpec }
    ) { state ->
        when (state) {
            AccountType.PERSON -> 1.1f
            AccountType.COMPANY -> 1f
        }
    }

    val companyBoxHeight by companyTransition.animateFloat(
        label = "Company Box Height",
        transitionSpec = { animationSpec }
    ) { state ->
        when (state) {
            AccountType.PERSON -> 0.6f
            AccountType.COMPANY -> 0.7f
        }
    }

    val companyBoxWeight by companyTransition.animateFloat(
        label = "Company Box Weight",
        transitionSpec = { animationSpec }
    ) { state ->
        when (state) {
            AccountType.PERSON -> 1f
            AccountType.COMPANY -> 1.1f
        }
    }

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        Background1()
        StatusBarInset {
            Box(modifier = Modifier.padding(Spacing.m)) {
                Crossfade(targetState = accountType.value) { type ->
                    when (type) {
                        AccountType.COMPANY -> {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(onClick = {
                                    navigator.navigate(
                                        RegisterCompanyScreenDestination
                                    )
                                }) {
                                    Icon(
                                        Icons.Filled.ArrowForwardIos,
                                        contentDescription = "Navigate to registration as company",
                                    )
                                }
                            }
                        }
                        AccountType.PERSON -> {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                IconButton(onClick = { navigator.navigate(RegisterScreenDestination) }) {
                                    Icon(
                                        Icons.Filled.ArrowBackIos,
                                        contentDescription = "Navigate to registration as person",
                                    )
                                }
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "What describes you the best?",
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(personBoxWeight)
                                .fillMaxHeight(personBoxHeight)
                                .clip(RoundedCornerShape(Spacing.l))
                                .background(
                                    Brush.verticalGradient(
                                        colors = if (accountType.value == AccountType.PERSON) listOf(
                                            Color.Magenta.copy(alpha = 0.02f),
                                            Color.Magenta.copy(alpha = 0.05f),
                                        ) else listOf(
                                            Color.Transparent,
                                            Color.Transparent
                                        )
                                    )
                                )
                                .border(
                                    BorderStroke(
                                        1.dp,
                                        if (accountType.value == AccountType.PERSON) Color.Magenta.copy(
                                            alpha = 0.2f
                                        ) else borderColor
                                    ),
                                    shape = RoundedCornerShape(Spacing.l)
                                )
                                .clickable { accountType.value = AccountType.PERSON }
                                .padding(Spacing.m),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                "Person",
                                modifier = Modifier.padding(bottom = Spacing.m),
                                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                                color = if (accountType.value == AccountType.PERSON) Color.White else MaterialTheme.typography.headlineMedium.color
                            )
                            Text(
                                "Discover Bars, Parties & Night Clubs or arrange your own party.",
                                modifier = Modifier.padding(bottom = Spacing.m),
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                color = if (accountType.value == AccountType.PERSON) Color.White else MaterialTheme.typography.bodyMedium.color
                            )
                        }
                        Spacer(modifier = Modifier.fillMaxWidth(0.05f))
                        Column(
                            modifier = Modifier
                                .weight(companyBoxWeight)
                                .fillMaxHeight(companyBoxHeight)
                                .clip(RoundedCornerShape(Spacing.l))
                                .background(
                                    Brush.verticalGradient(
                                        colors = if (accountType.value == AccountType.COMPANY) listOf(
                                            Color.Blue.copy(alpha = 0.02f),
                                            Color.Blue.copy(alpha = 0.05f),
                                        ) else listOf(
                                            Color.Transparent,
                                            Color.Transparent
                                        )
                                    )
                                )
                                .border(
                                    BorderStroke(
                                        1.dp,
                                        if (accountType.value == AccountType.COMPANY) primaryDark else borderColor
                                    ),
                                    shape = RoundedCornerShape(Spacing.l)
                                )
                                .clickable { accountType.value = AccountType.COMPANY }
                                .padding(Spacing.m),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                "Bar or Night Club",
                                modifier = Modifier.padding(bottom = Spacing.m),
                                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                                color = if (accountType.value == AccountType.COMPANY) Color.White else MaterialTheme.typography.headlineMedium.color
                            )
                            Text(
                                "Coming soon...",
                                modifier = Modifier.padding(bottom = Spacing.m),
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                color = if (accountType.value == AccountType.COMPANY) Color.White else MaterialTheme.typography.bodyMedium.color
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Joined Before?", style = MaterialTheme.typography.bodyMedium)
                        Button(
                            text = "Login",
                            onClick = { navigator.navigate(LoginScreenDestination) },
                            textButton = true,
                        )
                    }
                }
            }
        }
    }
}