package com.app.turny.ui.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.repository.FavoriteRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        FavoriteRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(FavoritesUiState())

    val uiState: StateFlow<FavoritesUiState> =
        _uiState

    init {

        loadFavorites()
    }

    private fun loadFavorites() {

        viewModelScope.launch {

            _uiState.value =
                _uiState.value.copy(
                    isLoading = true
                )

            try {

                val token =
                    sessionManager.getToken()

                val userName =
                    sessionManager.getUserName() ?: ""

                if(token == null){

                    _uiState.value =
                        _uiState.value.copy(
                            isLoading = false,
                            error = "No session"
                        )

                    return@launch
                }

                val favorites =
                    repository.getFavorites(token)

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        favorites = favorites,

                        userName = userName
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        error = e.message
                    )
            }
        }
    }
}