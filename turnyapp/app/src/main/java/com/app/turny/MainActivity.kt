package com.app.turny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.turny.ui.auth.LoginScreen
import com.app.turny.ui.auth.RegisterClientScreen
import com.app.turny.ui.theme.TurnyappTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TurnyappTheme {
                LoginScreen()
                //RegisterClientScreen()
                //HomeClientScreen()
            }
        }
    }
}