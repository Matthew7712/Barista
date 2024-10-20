package com.matthew.matthewcoffix

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.matthew.matthewcoffix.presantation.theme.MatthewCoffixTheme
import com.matthew.matthewcoffix.ui.OnboardingScreen
import com.matthew.matthewcoffix.ui.signIn.SignIn

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatthewCoffixTheme {
                ScaffoldBody()
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun ScaffoldBody(

    ) {
        // Установка цвета статусбара
        val navController = rememberAnimatedNavController()

        Scaffold { innerPadding ->
            AnimatedNavHost(
                navController = navController,
                startDestination = "Onboarding",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(
                    "Onboarding",
                    enterTransition = { fadeIn() },
                    exitTransition = { fadeOut() }
                ) {
                    OnboardingScreen(navController = navController)
                }

                composable(
                    "SignIn"
                ) {
                    SignIn(navController = navController)
                }
            }
        }
    }
}
