package com.app.turny.ui.client

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import com.app.turny.ui.components.AppointmentCard
import com.app.turny.ui.components.CustomerBottomNavBar
import com.app.turny.ui.components.CustomerNavItem
import com.app.turny.ui.components.structure.AppHeader


@Composable
fun AppointmentsScreen(

    onNavigateToHome: () -> Unit,

    onNavigateToFavorites: () -> Unit,

    onNavigateToProfile: () -> Unit,

    viewModel: AppointmentsViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            // CONTENIDO
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
                    AppHeader(
                        userName = uiState.userName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 18.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                ) {

                    Text(
                        text = "Mis citas",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Citas próximas",
                        color = Color.Gray,
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // TABS
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color(0xFFE9EDF3))
                            .padding(4.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF4D8DFF),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "» Próximas",
                                color = Color(0xFF4D8DFF),
                                fontWeight = FontWeight.Medium,
                                fontSize = 13.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "Historial",
                                color = Color.Gray,
                                fontSize = 13.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {

                        items(uiState.appointments) {

                            AppointmentCard(

                                serviceName =
                                    it.servicioNombre,

                                businessName =
                                    it.negocioNombre,

                                date =
                                    it.fecha,

                                hour =
                                    it.hora,

                                price =
                                    "$${it.precio}",

                                status = it.estado,

                                statusColor = when(it.estado){

                                    "CONFIRMADA" ->
                                        Color(0xFF4CAF50)

                                    "PENDIENTE" ->
                                        Color(0xFFE0A800)

                                    else ->
                                        Color.Gray
                                }
                            )
                        }
                    }
                }
            }

            CustomerBottomNavBar(
                selectedItem = CustomerNavItem.APPOINTMENTS,
                onItemSelected = { item ->

                    when(item){

                        CustomerNavItem.EXPLORE -> {

                            onNavigateToHome()
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
}