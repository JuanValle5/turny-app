package com.app.turny.ui.client

import com.app.turny.data.remote.dto.favorite.FavoriteResponse

data class FavoritesUiState(

    val isLoading: Boolean = false,

    val favorites:
    List<FavoriteResponse> = emptyList(),

    val userName: String = "",

    val error: String? = null
)