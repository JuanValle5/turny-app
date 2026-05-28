package com.app.turny.ui.client.profileBusiness

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.cards.ServiceCard

data class ServiceItem(
    val title: String,
    val description: String,
    val duration: String,
    val price: String
)

@Composable
fun BusinessServicesScreen(

    businessId: String,

    viewModel: BusinessServicesViewModel =
        viewModel()
){
    val uiState by
    viewModel.uiState.collectAsState()

    LaunchedEffect(Unit){

        viewModel.loadServices(
            businessId
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        // HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFD9D9D9),
                            Color(0xFFBDBDBD)
                        )
                    )
                )
        ) {

            // ICONOS SUPERIORES
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp,
                        vertical = 12.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CircleIconButton(
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )

                Row {

                    CircleIconButton(
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    CircleIconButton(
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Share,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    )
                }
            }

            // INFO NEGOCIO
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 18.dp
                    )
            ) {

                Text(
                    text = "Uñas & Glamour",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Salón de uñas",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "4.9",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "(203)",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 12.sp
                    )
                }
            }
        }

        // TABS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Servicios",
                    color = Color(0xFF1495F1),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    color = Color(0xFF1495F1),
                    thickness = 2.dp
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Información",
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // LISTA SERVICIOS
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp),

            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 20.dp
            )
        ) {

            items(uiState.services) { service ->

                ServiceCard(

                    title =
                        service.nombre,

                    description =
                        service.descripcion ?: "",

                    duration =
                        service.duracionFormateada,

                    price =
                        service.precio.toString(),

                    onReserveClick = {}
                )
            }
        }
    }
}

@Composable
fun CircleIconButton(
    icon: @Composable () -> Unit
) {

    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(Color.Black.copy(alpha = 0.25f)),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}