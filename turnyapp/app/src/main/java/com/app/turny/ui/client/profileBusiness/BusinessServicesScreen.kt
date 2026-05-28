package com.app.turny.ui.client.profileBusiness

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    onNavigateToReservation: () -> Unit,

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

    var selectedTab by remember {

        mutableStateOf(0)
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
                    //BOTON FAVORITO
                    CircleIconButton(

                        onClick = {

                            viewModel.toggleFavorite(
                                businessId
                            )
                        },

                        icon = {

                            Icon(

                                imageVector =
                                    if(uiState.isFavorite){

                                        Icons.Filled.Favorite

                                    } else {

                                        Icons.Outlined.FavoriteBorder
                                    },

                                contentDescription = null,

                                tint =
                                    if(uiState.isFavorite)
                                        Color.Red
                                    else
                                        Color.White
                            )
                        }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // BOTON COMPARTIR
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
                    text = uiState.businessName,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = uiState.businessCategory,
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
                        text = uiState.rating,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "(${uiState.reviews})",
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
                modifier = Modifier
                    .weight(1f)
                    .clickable {

                        selectedTab = 0
                    },

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Text(

                    text = "Servicios",

                    color =
                        if(selectedTab == 0)
                            Color(0xFF1495F1)
                        else
                            Color.Gray,

                    fontSize = 13.sp,

                    fontWeight =
                        if(selectedTab == 0)
                            FontWeight.SemiBold
                        else
                            FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Divider(

                    color =
                        if(selectedTab == 0)
                            Color(0xFF1495F1)
                        else
                            Color.Transparent,

                    thickness = 2.dp
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable {

                        selectedTab = 1
                    },

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Text(

                    text = "Información",

                    color =
                        if(selectedTab == 1)
                            Color(0xFF1495F1)
                        else
                            Color.Gray,

                    fontSize = 13.sp,

                    fontWeight =
                        if(selectedTab == 1)
                            FontWeight.SemiBold
                        else
                            FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Divider(

                    color =
                        if(selectedTab == 1)
                            Color(0xFF1495F1)
                        else
                            Color.Transparent,

                    thickness = 2.dp
                )
            }
        }

        // LISTA SERVICIOS
        if(selectedTab == 0){

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

        } else {

            BusinessInfoContent(
                uiState = uiState
            )
        }
    }
}

@Composable
fun BusinessInfoContent(
    uiState: BusinessServicesUiState
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(16.dp)
    ) {

        // SOBRE NOSOTROS
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(20.dp)
                )
                .padding(18.dp)
        ) {

            Column {

                Text(
                    text = "Sobre nosotros",

                    fontWeight = FontWeight.Bold,

                    fontSize = 18.sp
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text =
                        if(uiState.description.isBlank())
                            "Sin descripción"
                        else
                            uiState.description,

                    color = Color.DarkGray
                )
            }
        }

        // CONTACTO
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(20.dp)
                )
                .padding(18.dp)
        ) {

            Column {

                Text(
                    text = "Contacto",

                    fontWeight = FontWeight.Bold,

                    fontSize = 18.sp
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                InfoRow(
                    title = "Dirección",
                    value = uiState.address
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                InfoRow(
                    title = "Teléfono",
                    value = uiState.phone
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                InfoRow(
                    title = "Email",
                    value = uiState.email
                )
            }
        }
    }
}
@Composable
fun InfoRow(

    title: String,

    value: String
) {

    Column {

        Text(

            text = title,

            color = Color.Gray,

            fontSize = 12.sp
        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Text(

            text = value,

            color = Color.Black,

            fontSize = 15.sp,

            fontWeight = FontWeight.Medium
        )
    }
}
@Composable
fun CircleIconButton(

    onClick: () -> Unit = {},

    icon: @Composable () -> Unit
) {

    Box(
        modifier = Modifier.clickable {

            onClick()
        }
            .size(34.dp)
            .clip(CircleShape)
            .background(Color.Black.copy(alpha = 0.25f)),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}