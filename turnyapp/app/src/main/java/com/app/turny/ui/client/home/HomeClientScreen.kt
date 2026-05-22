package com.app.turny.ui.client.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.app.turny.ui.components.business.BusinessCard
import com.app.turny.ui.components.CustomerBottomNavBar
import com.app.turny.ui.components.CustomerNavItem
import com.app.turny.ui.components.structure.AppHeader

data class Negocio(
    val nombre: String,
    val tipo: String,
    val direccion: String,
    val horario: String,
    val rating: String
)

@Composable
fun HomeClientScreen(

    onNavigateToProfile: () -> Unit,

    onNavigateToAppointments: () -> Unit,

    onNavigateToFavorites: () -> Unit,

    viewModel: HomeClientViewModel = viewModel()

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

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),

                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {

                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {

                    AppHeader(
                        userName = uiState.userName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp)
                    )
                }

                item {

                    HorizontalDivider(
                        color = Color(0xFFE5E5E5)
                    )
                }

                item {

                    ExploreSection()
                }

                item {

                    SearchSection()
                }

                item {

                    CategoriesSection()
                }

                item {

                    Text(
                        text = "${uiState.businesses.size} negocios encontrados",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }

                items(uiState.businesses) { negocio ->

                    BusinessCard(negocio)
                }

                item {

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        // FOOTER
        CustomerBottomNavBar(

            selectedItem = CustomerNavItem.EXPLORE,

            onItemSelected = { item ->

                when(item){

                    CustomerNavItem.APPOINTMENTS -> {

                        onNavigateToAppointments()
                    }

                    CustomerNavItem.FAVORITES -> {

                        onNavigateToFavorites()
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

@Composable
fun ExploreSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {

            Text(
                text = "Explorar",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Encuentra tu servicio ideal",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        TextButton(
            onClick = {},
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E5E5),
                    shape = RoundedCornerShape(14.dp)
                )
        ) {
            Text(text = "📷 Código")
        }
    }
}

@Composable
fun SearchSection() {

    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text("Buscar negocios, servicios...")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFE5E5E5),
            unfocusedBorderColor = Color(0xFFE5E5E5),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}

@Composable
fun CategoriesSection() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        CategoryChip(
            text = "Todos",
            selected = true
        )

        CategoryChip(
            text = "Barberías",
            selected = false
        )

        CategoryChip(
            text = "Peluquerías",
            selected = false
        )
    }
}

@Composable
fun CategoryChip(
    text: String,
    selected: Boolean
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) Color(0xFF3B82F6)
                else Color(0xFFE9EDF5)
            )
            .clickable { }
            .padding(horizontal = 18.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            color = if (selected) Color.White else Color.DarkGray
        )
    }
}