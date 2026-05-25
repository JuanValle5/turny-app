package com.app.turny.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.turny.ui.auth.login.LoginScreen
import com.app.turny.ui.auth.register.RegisterClientScreen
import com.app.turny.ui.business.ConfigurationBusinessScreen
import com.app.turny.ui.business.HomeBusinessScreen
import com.app.turny.ui.client.home.HomeClientScreen
import com.app.turny.ui.client.profile.ProfileScreen
import com.app.turny.ui.client.appointment.AppointmentsScreen
import com.app.turny.ui.client.favorite.FavoritesScreen
import com.app.turny.ui.client.profileBusiness.BusinessServicesScreen
import com.app.turny.ui.splash.SplashViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val splashViewModel: SplashViewModel = viewModel()

    val startDestination by
    splashViewModel.startDestination.collectAsState()

    NavHost(
        navController = navController,
        startDestination = startDestination
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
                },

                onNavigateToAppointments = {

                    navController.navigate(
                        Screen.Appointments.route
                    )
                },

                onNavigateToFavorites = {

                    navController.navigate(
                        Screen.Favorites.route
                    )
                },
                onNavigateToBusiness = { businessId ->

                    navController.navigate(

                        Screen.BusinessServices
                            .createRoute(businessId)
                    )
                }
            )
        }

        composable(Screen.HomeBusiness.route) {

            HomeBusinessScreen(

                onNavigateToConfiguration = {

                    navController.navigate(
                        Screen.ConfigurationBusiness.route
                    )
                }
            )
        }


        composable(Screen.ProfileClient.route) {

            ProfileScreen(

                onLogout = {

                    navController.navigate(Screen.Login.route){

                        popUpTo(0)
                    }
                },

                onNavigateToHome = {

                    navController.navigate(
                        Screen.HomeClient.route
                    )
                },

                onNavigateToAppointments = {

                    navController.navigate(
                        Screen.Appointments.route
                    )
                },

                onNavigateToFavorites = {

                    navController.navigate(
                        Screen.Favorites.route
                    )
                }
            )
        }

        composable(Screen.Appointments.route) {

            AppointmentsScreen(

                onNavigateToHome = {

                    navController.navigate(
                        Screen.HomeClient.route
                    )
                },

                onNavigateToFavorites = {

                    navController.navigate(
                        Screen.Favorites.route
                    )
                },

                onNavigateToProfile = {

                    navController.navigate(
                        Screen.ProfileClient.route
                    )
                }
            )
        }

        composable(Screen.Favorites.route) {

            FavoritesScreen(

                onNavigateToHome = {

                    navController.navigate(
                        Screen.HomeClient.route
                    )
                },

                onNavigateToAppointments = {

                    navController.navigate(
                        Screen.Appointments.route
                    )
                },

                onNavigateToProfile = {

                    navController.navigate(
                        Screen.ProfileClient.route
                    )
                }
            )
        }

        composable(
            route =
                Screen.BusinessServices.route
        ) { backStackEntry ->

            val businessId =
                backStackEntry.arguments
                    ?.getString("businessId")
                    ?: ""

            BusinessServicesScreen(
                businessId = businessId
            )
        }

        composable(
            Screen.ConfigurationBusiness.route
        ) {

            ConfigurationBusinessScreen()
        }
    }
}