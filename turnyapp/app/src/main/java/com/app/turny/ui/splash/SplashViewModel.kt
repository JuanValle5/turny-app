package com.app.turny.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    private val _startDestination =
        MutableStateFlow("login")

    val startDestination: StateFlow<String> =
        _startDestination

    init {

        checkSession()
    }

    private fun checkSession() {

        viewModelScope.launch {

            val token =
                sessionManager.getToken()

            val userType =
                sessionManager.getUserType()

            _startDestination.value = when {

                token == null -> "login"

                userType == "client" ->
                    "home_client"

                userType == "business" ->
                    "home_business2"

                else -> "login"
            }
        }
    }
}