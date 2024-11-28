package com.matthew.matthewcoffix

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.matthew.matthewcoffix.data.DatabaseConnection
import com.matthew.matthewcoffix.data.event.UserEvent
import com.matthew.matthewcoffix.data.state.UserState
import com.matthew.matthewcoffix.data.viewmodel.ProductViewModel
import com.matthew.matthewcoffix.data.viewmodel.UserViewModel
import com.matthew.matthewcoffix.presantation.common.component.BottomNavigationBar
import com.matthew.matthewcoffix.presantation.theme.MatthewCoffixTheme
import com.matthew.matthewcoffix.ui.product.Product
import com.matthew.matthewcoffix.ui.onboarding.OnboardingScreen
import com.matthew.matthewcoffix.ui.home.HomeScreen
import com.matthew.matthewcoffix.ui.menu.MenuScreen
import com.matthew.matthewcoffix.ui.profile.ProfileScreen
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

    private val productViewModel by viewModels<ProductViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ProductViewModel() as T
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
                val navController = rememberNavController()
                Host (state = state, onEvent = viewModel::onEvent, navController = navController)
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun Host(
        state: UserState,
        onEvent: (UserEvent) -> Unit,
        navController: NavHostController
    ) {

        // Получаем текущий маршрут из бэкстека
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Scaffold(
        ) { innerPadding ->
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ){
                AnimatedNavHost(
                    navController = navController,
                    startDestination = "Product/1",
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
                            userViewModel = viewModel
                        )
                    }

                    composable("Sign Up") {
                        SignUp(navController = navController, onEvent = onEvent, state = state)
                    }

                    composable("Home") {
                        HomeScreen(state = state, onEvent = onEvent)
                    }

                    composable("Menu Screen") {
                        MenuScreen(navController = navController)
                    }

                    composable("Product/{id}") { navBackStackEntry ->
                        val menuItemId = navBackStackEntry.arguments?.getString("id")
                        val proViewModel: ProductViewModel = productViewModel
                        if (menuItemId != null) {
                            Product(navController = navController, viewModel = productViewModel, id = menuItemId.toInt())
                        }
                    }

                    composable("Profile") {
                        ProfileScreen()
                    }
                }
                if (currentRoute == "Home" || currentRoute == "Menu Screen" || currentRoute == "Profile") {
                    BottomNavigationBar(navController = navController)
                }
            }
        }
    }
}