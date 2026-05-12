package com.app.turny.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.turny.ui.auth.LoginScreen
import com.app.turny.ui.auth.RegisterClientScreen

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
    }
}