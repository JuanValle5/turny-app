package com.app.turny.navigation


sealed class Screen(val route: String) {

    data object Login : Screen("login")

    data object RegisterClient : Screen("register_client")
    data object HomeClient : Screen("home_client")

    data object HomeBusiness : Screen("home_business")
}