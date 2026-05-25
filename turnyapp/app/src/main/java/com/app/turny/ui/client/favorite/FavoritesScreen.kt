package com.app.turny.ui.client.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.app.turny.ui.components.structure.AppHeader
import com.app.turny.ui.components.CustomerBottomNavBar
import com.app.turny.ui.components.CustomerNavItem
import com.app.turny.ui.components.FavoriteBusinessCard

@Composable
fun FavoritesScreen(
    onNavigateToHome: () -> Unit,

    onNavigateToAppointments: () -> Unit,

    onNavigateToProfile: () -> Unit,

    viewModel: FavoritesViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
    ) {

        // CONTENT
        Column(
            modifier = Modifier
                .weight(1f)
        ) {

            AppHeader(
                userName = uiState.userName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "Favoritos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${uiState.favorites.size} negocios guardados",
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    items(uiState.favorites) {

                        FavoriteBusinessCard(

                            businessName =
                                it.negocioNombre,

                            businessType =
                                it.negocioCategoria,

                            rating =
                                it.rating.toString(),

                            schedule =
                                "Favorito guardado"
                        )
                    }
                }
            }
        }

        // BOTTOM NAVIGATION
        CustomerBottomNavBar(
            selectedItem = CustomerNavItem.FAVORITES,
            onItemSelected = { item ->

                when(item){

                    CustomerNavItem.EXPLORE -> {

                        onNavigateToHome()
                    }

                    CustomerNavItem.APPOINTMENTS -> {

                        onNavigateToAppointments()
                    }

                    CustomerNavItem.PROFILE -> {

                        onNavigateToProfile()
                    }

                    else -> {}
                }
            }
        )
    }
}