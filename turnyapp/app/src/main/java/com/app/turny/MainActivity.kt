package com.app.turny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.turny.navigation.AppNavigation
import com.app.turny.ui.business.configuration.BusinessHoursScreen
import com.app.turny.ui.business.service.NewServiceScreen

import com.app.turny.ui.theme.TurnyappTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TurnyappTheme {

                AppNavigation()
                //BusinessHoursScreen()
                //NewServiceScreen()
                //ServicesBusinessScreen()
                //HomeBusinessScreen2()
            //ReservationScreen()
                //BusinessServicesScreen()
                //ReservationsBusinessScreen()
                //ServicesBusinessScreen()
                //AppointmentsScreen()
                //FavoritesScreen()
                //ProfileScreen()
                //ConfigurationBusinessScreen()
            }
        }
    }
}