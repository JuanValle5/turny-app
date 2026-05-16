package com.app.turny.ui.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.repository.AuthRepositoryImpl
import com.app.turny.domain.model.Role
import com.app.turny.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val repository: AuthRepository = AuthRepositoryImpl()

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun onRoleChange(role: Role) {
        _uiState.value = _uiState.value.copy(selectedRole = role)
    }

    fun login() {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            try {

                val response = repository.login(

                    email = _uiState.value.email,

                    password = _uiState.value.password,

                    role = _uiState.value.selectedRole
                )

                _uiState.value = _uiState.value.copy(

                    isLoading = false,

                    success = true,

                    userType = response.tipo
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(

                    isLoading = false,

                    error = e.message
                )
            }
        }
    }
}