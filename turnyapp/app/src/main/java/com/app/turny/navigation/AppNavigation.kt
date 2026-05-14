package com.app.turny.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.turny.ui.auth.login.LoginScreen
import com.app.turny.ui.auth.register.RegisterClientScreen
import com.app.turny.ui.client.HomeClientScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        // LOGIN
        composable(Screen.Login.route) {

            LoginScreen(
                onNavigateToRegister = {

                    navController.navigate(
                        Screen.RegisterClient.route
                    )
                },

                onLoginSuccess = {

                    navController.navigate(
                        Screen.HomeClient.route
                    )
                }
            )
        }

        // REGISTER CLIENT
        composable(Screen.RegisterClient.route) {

            RegisterClientScreen(

                onBackClick = {
                    navController.popBackStack()
                },

                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.HomeClient.route) {

            HomeClientScreen()
        }
    }
}