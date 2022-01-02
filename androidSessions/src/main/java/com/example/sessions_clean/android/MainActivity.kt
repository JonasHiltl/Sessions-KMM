package com.example.sessions_clean.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sessions_clean.android.ui.navigation.nav_graph.SetupNavGraph
import com.example.sessions_clean.android.ui.theme.M3Theme
import com.example.sessions_clean.android.ui.theme.M3Theme

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberNavController()
            M3Theme() {
                SetupNavGraph(navController = navController)
            }
        }
    }
}
