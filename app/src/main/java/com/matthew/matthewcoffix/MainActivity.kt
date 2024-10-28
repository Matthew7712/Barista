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
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.matthew.matthewcoffix.presantation.common.component.BottomNavigationBar
import com.matthew.matthewcoffix.presantation.theme.MatthewCoffixTheme
import com.matthew.matthewcoffix.ui.OnboardingScreen
import com.matthew.matthewcoffix.ui.homeScreen.HomeScreen
import com.matthew.matthewcoffix.ui.signIn.SignIn
import com.matthew.matthewcoffix.ui.signUp.SignUp

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatthewCoffixTheme {
                Host()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun Host() {
        // Установка навигатора
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                // Проверяем текущий маршрут и отображаем нижнее меню только для HomeScreen
                if (navController.currentDestination?.route == "Home") {
                    BottomNavigationBar()
                }
            }
        ) { innerPadding ->
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

                composable("Sign In") {
                    SignIn(navController = navController)
                }

                composable("Sign Up") {
                    SignUp(navController = navController)
                }

                composable("Home") {
                    HomeScreen()
                }
            }
        }
    }
}
