package com.app.turny.ui.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    fun logout(
        onComplete: () -> Unit
    ) {

        viewModelScope.launch {

            sessionManager.clearSession()

            onComplete()
        }
    }
}