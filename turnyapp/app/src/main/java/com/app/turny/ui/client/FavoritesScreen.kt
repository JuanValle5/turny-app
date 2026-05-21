package com.app.turny.ui.client.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.turny.R
import com.app.turny.ui.components.CustomerBottomNavBar
import com.app.turny.ui.components.CustomerNavItem
import com.app.turny.ui.components.FavoriteBusinessCard

@Composable
fun FavoritesScreen(
    onNavigateToHome: () -> Unit,

    onNavigateToAppointments: () -> Unit,

    onNavigateToProfile: () -> Unit
) {

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

            // HEADER
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Turny",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE7F0FF)),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "AR",
                        color = Color(0xFF4D8DFF),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                }
            }

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
                    text = "1 negocio guardado",
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    items(1) {

                        FavoriteBusinessCard(
                            businessName = "Nombre del Negocio",
                            businessType = "Tipo de negocio",
                            rating = "5.0",
                            schedule = "Horario de atención"
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