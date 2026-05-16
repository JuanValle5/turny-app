package com.app.turny.ui.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.repository.AuthRepositoryImpl
import com.app.turny.domain.model.Role
import com.app.turny.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repository: AuthRepository = AuthRepositoryImpl()
    private val _uiState = MutableStateFlow(RegisterUiState())

    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onFullNameChange(name: String) {

        _uiState.value = _uiState.value.copy(
            fullName = name
        )
    }

    fun onEmailChange(email: String) {

        _uiState.value = _uiState.value.copy(
            email = email
        )
    }

    fun onPhoneChange(phone: String) {

        _uiState.value = _uiState.value.copy(
            phone = phone
        )
    }

    fun onPasswordChange(password: String) {

        _uiState.value = _uiState.value.copy(
            password = password
        )
    }

    fun onBusinessTypeChange(type: String) {

        _uiState.value = _uiState.value.copy(
            businessType = type
        )
    }

    fun onBusinessNameChange(name: String) {

        _uiState.value = _uiState.value.copy(
            businessName = name
        )
    }

    fun onBusinessAddressChange(address: String) {

        _uiState.value = _uiState.value.copy(
            businessAddress = address
        )
    }

    fun onRoleChange(role: Role) {

        _uiState.value = _uiState.value.copy(
            selectedRole = role
        )
    }

    fun register() {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            try {

                val response = repository.register(

                    fullName = _uiState.value.fullName,

                    email = _uiState.value.email,

                    phone = _uiState.value.phone,

                    password = _uiState.value.password,

                    role = _uiState.value.selectedRole,

                    businessType = _uiState.value.businessType,

                    businessName = _uiState.value.businessName,

                    businessAddress = _uiState.value.businessAddress
                )

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    success = response.success
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