package com.app.turny.ui.client.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.turny.ui.components.boton.ConfirmReservationButton
import com.app.turny.ui.components.boton.DateButton
import com.app.turny.ui.components.boton.HourButton
import com.app.turny.ui.components.cards.ReservationServiceCard
import com.app.turny.ui.components.input.NotesInput

@Composable
fun ReservationScreen(

    businessId: String,

    serviceId: String,

    businessName: String,

    serviceName: String,

    price: String,

    duration: String
) {

    var notes by remember { mutableStateOf("") }

    val hours = listOf(
        "09:00", "09:30", "10:00", "10:30",
        "11:00", "11:30", "12:00", "14:00",
        "14:30", "15:00", "15:30", "16:00",
        "16:30", "17:00", "17:30", "18:00"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
    ) {

        // HEADER
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {}
                ) {

                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))

                Column {

                    Text(
                        text = "Reservar cita",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = businessName,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            HorizontalDivider(
                color = Color(0xFFD9D9D9)
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                ReservationServiceCard(

                    title = serviceName,

                    description = "",

                    duration = duration,

                    price = price
                )
            }

            item {
                Text(
                    text = "Selecciona una fecha",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item {
                        DateButton("VIE", "23", "may", true) {}
                    }
                    item {
                        DateButton("SÁB", "24", "may", false) {}
                    }
                    item {
                        DateButton("DOM", "25", "may", false) {}
                    }
                    item {
                        DateButton("LUN", "26", "may", false) {}
                    }
                }
            }

            item {
                Text(
                    text = "Selecciona una hora",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier.height(220.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(hours) { hour ->

                        HourButton(
                            hour = hour,
                            selected = hour == "16:00",
                            onClick = {}
                        )
                    }
                }
            }


            item {
                Text(
                    text = "Notas adicionales (opcional)",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            item {
                NotesInput(
                    value = notes,
                    onValueChange = {
                        notes = it
                    }
                )
            }

        }

        // FOOTER
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(14.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Total a pagar",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Text(
                    text = "$$price",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            ConfirmReservationButton(
                onClick = {}
            )
        }
    }
}