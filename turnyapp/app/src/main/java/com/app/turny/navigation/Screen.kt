package com.app.turny.navigation


sealed class Screen(val route: String) {

    data object Login : Screen("login")

    data object RegisterClient : Screen("register_client")
}