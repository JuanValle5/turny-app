package com.app.turny.ui.client

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
    onNavigateToProfile: () -> Unit
) {

    val negocios = listOf(
        Negocio(
            nombre = "Nombre de negocio",
            tipo = "Tipo de negocio",
            direccion = "Dirección",
            horario = "Horario",
            rating = "5.0"
        ),
        Negocio(
            nombre = "Nombre de negocio",
            tipo = "Tipo de negocio",
            direccion = "Dirección",
            horario = "Horario",
            rating = "5.0"
        )
    )

    Scaffold(
        bottomBar = {

            CustomerBottomNavBar(

                selectedItem = CustomerNavItem.EXPLORE,

                onItemSelected = { item ->

                    when(item){

                        CustomerNavItem.PROFILE -> {
                            onNavigateToProfile()
                        }

                        else -> {}
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5))
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                AppHeader(
                    userName = "Andy Rubin",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                HorizontalDivider(color = Color(0xFFE5E5E5))
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
                    text = "4 negocios encontrados",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            items(negocios) { negocio ->
                BusinessCard(negocio)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun HeaderSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD9F0FF)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🗓")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Turny",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color(0xFFE3EDFF)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "AR",
                color = Color(0xFF3B82F6),
                fontWeight = FontWeight.Bold
            )
        }
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

@Composable
fun BusinessCard(
    negocio: Negocio
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFE5E5E5)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🖼")
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = negocio.nombre,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = null,
                            tint = Color(0xFFF59E0B),
                            modifier = Modifier.size(18.dp)
                        )

                        Text(
                            text = negocio.rating
                        )

                        Text(
                            text = " (156)",
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = negocio.tipo,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = negocio.direccion,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = negocio.horario,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}