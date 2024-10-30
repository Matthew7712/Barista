package com.matthew.matthewcoffix

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.matthew.matthewcoffix.data.DatabaseConnection
import com.matthew.matthewcoffix.data.event.UserEvent
import com.matthew.matthewcoffix.data.state.UserState
import com.matthew.matthewcoffix.data.viewmodel.UserViewModel
import com.matthew.matthewcoffix.presantation.common.component.BottomNavigationBar
import com.matthew.matthewcoffix.presantation.theme.MatthewCoffixTheme
import com.matthew.matthewcoffix.ui.OnboardingScreen
import com.matthew.matthewcoffix.ui.homeScreen.HomeScreen
import com.matthew.matthewcoffix.ui.signIn.SignIn
import com.matthew.matthewcoffix.ui.signUp.SignUp

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            DatabaseConnection::class.java,
            "Barista"
        ).build()
    }
    private val viewModel by viewModels<UserViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return UserViewModel(db.userDao) as T
                }
            }
        }
    )


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatthewCoffixTheme {
                val state by viewModel.state.collectAsState()
                Host (state = state, onEvent = viewModel::onEvent)
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun Host(
        state: UserState,
        onEvent: (UserEvent) -> Unit
    ) {
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
                    SignIn(
                        navController = navController,
                        onEvent = onEvent,
                        state = state,
                        userViewModel = viewModel)
                }

                composable("Sign Up") {
                    SignUp(navController = navController, onEvent = onEvent, state = state)
                }

                composable("Home") {
                    HomeScreen(state = state, onEvent = onEvent)
                }
            }
        }
    }
}
