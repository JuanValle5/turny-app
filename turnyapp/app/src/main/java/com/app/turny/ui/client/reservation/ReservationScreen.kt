package com.app.turny.ui.client.reservation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CalendarMonth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.boton.ConfirmReservationButton
import com.app.turny.ui.components.boton.DateButton
import com.app.turny.ui.components.boton.HourButton
import com.app.turny.ui.components.cards.ReservationServiceCard
import com.app.turny.ui.components.input.NotesInput
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun ReservationScreen(

    businessId: String,

    serviceId: String,

    businessName: String,

    serviceName: String,

    price: String,

    duration: String,

    onBack: () -> Unit = {},

    viewModel: ReservationViewModel =
        viewModel()
) {

    val uiState by
    viewModel.uiState.collectAsState()

    val context =
        LocalContext.current

    LaunchedEffect(
        uiState.selectedDate
    ) {

        viewModel.loadSlots(

            businessId = businessId,

            serviceId = serviceId
        )
    }

    LaunchedEffect(
        uiState.success
    ) {

        if(uiState.success){

            Toast.makeText(

                context,

                "Reserva creada correctamente",

                Toast.LENGTH_SHORT

            ).show()

            onBack()
        }
    }

    val dates =
        (0..6).map {

            LocalDate.now().plusDays(
                it.toLong()
            )
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F8FA))
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(horizontal = 20.dp)
        ) {

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // HEADER
            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                ) {

                    IconButton(
                        onClick = {

                            onBack()
                        }
                    ) {

                        Icon(
                            imageVector =
                                Icons.Outlined.ArrowBack,

                            contentDescription = null
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(14.dp)
                )

                Column {

                    Text(
                        text = "Reservar cita",

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = businessName,

                        color = Color.Gray
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // SERVICE CARD
            ReservationServiceCard(

                title = serviceName,

                description = "",

                duration = duration,

                price = price
            )

            Spacer(
                modifier = Modifier.height(26.dp)
            )

            // DATE SECTION
            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Outlined.CalendarMonth,

                    contentDescription = null,

                    tint = Color(0xFF1495F1)
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "Selecciona una fecha",

                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            LazyRow(
                horizontalArrangement =
                    Arrangement.spacedBy(12.dp),

                contentPadding =
                    PaddingValues(end = 12.dp)
            ) {

                items(dates) { date ->

                    DateButton(

                        dayName =
                            date.dayOfWeek
                                .getDisplayName(
                                    TextStyle.SHORT,
                                    Locale("es")
                                ),

                        dayNumber =
                            date.dayOfMonth
                                .toString(),

                        month =
                            date.month
                                .getDisplayName(
                                    TextStyle.SHORT,
                                    Locale("es")
                                ),

                        selected =
                            uiState.selectedDate == date,

                        onClick = {

                            viewModel.selectDate(
                                date
                            )
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // HOURS SECTION
            Text(
                text = "Horarios disponibles",

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            LazyRow(
                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                items(uiState.slots) { slot ->

                    if(slot.disponible){

                        HourButton(

                            hour =
                                slot.horaFormateada,

                            selected =
                                uiState.selectedHour ==
                                        slot.hora,

                            onClick = {

                                viewModel.selectHour(
                                    slot.hora
                                )
                            }
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // NOTES
            Text(
                text = "Notas",

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            NotesInput(

                value = uiState.notes,

                onValueChange = {

                    viewModel.onNotesChange(it)
                }
            )

            if(uiState.error != null){

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(

                    text = uiState.error ?: "",

                    color = Color.Red
                )
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }

        // FOOTER
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Total",

                    color = Color.Gray
                )

                Text(
                    text = "$$price",

                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            ConfirmReservationButton(

                onClick = {

                    viewModel.createAppointment(

                        businessId = businessId,

                        serviceId = serviceId
                    )
                }
            )
        }
    }
}