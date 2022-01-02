package com.example.sessions_clean.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import com.example.sessions_clean.android.ui.navigation.nav_graph.SetupNavGraph
import com.example.sessions_clean.android.ui.theme.M3Theme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberAnimatedNavController()
            M3Theme() {
                SetupNavGraph(navController = navController)
            }
        }
    }
}
