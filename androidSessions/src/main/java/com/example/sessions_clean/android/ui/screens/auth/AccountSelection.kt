package com.example.sessions_clean.android.ui.screens.auth

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sessions_clean.android.ui.components.Button
import com.example.sessions_clean.android.ui.navigation.Screen
import com.example.sessions_clean.android.ui.theme.*

private enum class AccountType {
    PERSON, COMPANY
}

private val animationSpec: FiniteAnimationSpec<Float> = tween(
    durationMillis = 200,
    easing = FastOutSlowInEasing
)

@ExperimentalAnimationApi
@Composable
fun AccountSelection(
    navController: NavController
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
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(Spacing.s)
            .fillMaxSize(),
    ) {
        Crossfade(targetState = accountType.value) { type ->
            when (type) {
                AccountType.COMPANY -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { navController.navigate(Screen.RegisterCompany.route) }) {
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
                        IconButton(onClick = { navController.navigate(Screen.Register.route) }) {
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
                                    gradientPink,
                                    gradientPurple,
                                ) else listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                )
                            )
                        )
                        .border(
                            BorderStroke(
                                1.dp,
                                if (accountType.value == AccountType.PERSON) borderColor else borderColor
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
                                    primaryLight,
                                    primaryDark,
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
                    onClick = { navController.navigate(Screen.Login.route) },
                    textButton = true,
                )
            }
        }

    }
}