package com.app.turny.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.turny.ui.auth.login.LoginScreen
import com.app.turny.ui.auth.register.RegisterClientScreen
import com.app.turny.ui.business.HomeBusinessScreen
import com.app.turny.ui.client.HomeClientScreen
import com.app.turny.ui.client.ProfileScreen

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

                onClientLoginSuccess = {

                    navController.navigate(
                        Screen.HomeClient.route
                    ) {

                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                },

                onBusinessLoginSuccess = {

                    navController.navigate(
                        Screen.HomeBusiness.route
                    ) {

                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
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

            HomeClientScreen(

                onNavigateToProfile = {

                    navController.navigate(
                        Screen.ProfileClient.route
                    )
                }
            )
        }

        composable(Screen.HomeBusiness.route) {

            HomeBusinessScreen()
        }
        composable(Screen.ProfileClient.route) {

            ProfileScreen(

                onLogout = {

                    navController.navigate(Screen.Login.route){

                        popUpTo(0)
                    }
                }
            )
        }
    }
}