package com.app.turny.ui.auth

import com.app.turny.domain.model.Role

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val selectedRole: Role = Role.CLIENT,
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)