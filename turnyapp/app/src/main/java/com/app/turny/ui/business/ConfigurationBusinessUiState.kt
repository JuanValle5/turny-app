package com.app.turny.ui.business

data class ConfigurationBusinessUiState(

    val ownerName: String = "",

    val businessName: String = "",

    val email: String = "",

    val businessEmail: String = "",

    val phone: String = "",

    val whatsapp: String = "",

    val address: String = "",

    val city: String = "",

    val category: String = "",

    val website: String = "",

    val description: String = "",

    val businessCode: String = "",

    val rating: Double = 0.0,

    val reviews: Int = 0,

    val verified: Boolean = false,

    val isLoading: Boolean = false,

    val error: String? = null
)