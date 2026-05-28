package com.app.turny.navigation


sealed class Screen(val route: String) {

    data object Login : Screen("login")

    data object RegisterClient : Screen("register_client")
    data object HomeClient : Screen("home_client")

    //data object HomeBusiness : Screen("home_business")
    data object HomeBusiness2 : Screen("home_business2")

    data object ProfileClient : Screen("profile_client")

    data object Appointments : Screen("appointments")

    data object Favorites : Screen("favorites")

    data object BusinessServices :
        Screen("business_services/{businessId}") {

        fun createRoute(
            businessId: String
        ) = "business_services/$businessId"
    }

    data object ConfigurationBusiness :
        Screen("configuration_business")

    data object ServicesBusiness :
        Screen("services_business")

    data object NewService :
        Screen("new_service")

    data object Reservation:
            Screen("reservation")
}