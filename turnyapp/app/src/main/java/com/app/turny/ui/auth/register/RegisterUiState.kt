package com.app.turny.ui.auth.register

import com.app.turny.domain.model.Role

data class RegisterUiState(

    val fullName: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val selectedRole: Role = Role.CLIENT,
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)