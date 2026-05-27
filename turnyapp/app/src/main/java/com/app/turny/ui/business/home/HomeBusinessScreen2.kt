package com.app.turny.ui.business.home

import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.BusinessBottomNavBar
import com.app.turny.ui.components.BusinessNavItem
import com.app.turny.ui.components.cards.AppointmentBusinessCard
import com.app.turny.ui.components.cards.AppointmentStatus
import com.app.turny.ui.components.cards.StatsCardsSection
import com.app.turny.ui.components.structure.AppHeader
import java.time.LocalDate

@Composable
fun HomeBusinessScreen2(
    onNavigateToProfile: () -> Unit,
    onNavigateToService: () -> Unit,
    viewModel: HomeBusinessViewModel =
        viewModel()
    //viewModel: BusinessViewModel = viewModel()
) {

    val uiState by
    viewModel.uiState.collectAsState()

    val startOfWeek =
        uiState.selectedDate.minusDays(
            uiState.selectedDate.dayOfWeek.value.toLong() - 1
        )

    val weekDays = (0..6).map { index ->

        val date =
            startOfWeek.plusDays(index.toLong())

        DayItem2(

            name =
                date.dayOfWeek.name
                    .take(3),

            number =
                date.dayOfMonth.toString(),

            date = date,

            selected =
                date == uiState.selectedDate
        )
    }

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
            AppHeader(
                userName = uiState.userName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            )

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
                    HorizontalDivider(
                        color = Color(0xFFE5E5E5)
                    )
                }

                item {
                    // SALUDO
                    Text(
                        text = "Buen día!",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    val currentDate = LocalDate.now()

                    val formatter = DateTimeFormatter.ofPattern(
                        "EEEE, d 'de' MMMM",
                        Locale("es", "ES")
                    )

                    Text(
                        text = currentDate.format(formatter)
                            .replaceFirstChar { it.uppercase() },
                        fontSize = 16.sp,
                        color = Color(0xFF8A8A8A)
                    )
                }
                item {
                    StatsCardsSection(

                        total =
                            uiState.totalAppointments,

                        confirmed =
                            uiState.confirmedAppointments,

                        pending =
                            uiState.pendingAppointments
                    )
                }

                item {
                    WeeklyCalendarCard(

                        days = weekDays,

                        onDateSelected = { date ->

                            viewModel.selectDate(date)
                        }
                    )
                }

                item {
                    // TÍTULO CITAS
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text =
                                if(
                                    uiState.selectedDate ==
                                    LocalDate.now()
                                ){

                                    "Citas - hoy"

                                } else {

                                    "Citas"
                                },
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text =
                                "${uiState.appointments.size} citas",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }

                items(uiState.appointments) { appointment ->

                    val status = when(

                        appointment.estado.uppercase()
                    ) {

                        "PENDIENTE" -> {

                            AppointmentStatus.PENDING
                        }

                        "COMPLETADA" -> {

                            AppointmentStatus.COMPLETED
                        }

                        else -> {

                            AppointmentStatus.CONFIRMED
                        }
                    }

                    AppointmentBusinessCard(

                        serviceName = appointment.servicioNombre,

                        clientName = "Cliente",

                        hour = appointment.hora.toString(),

                        duration = appointment.duracionFormateada,

                        status = status,

                        onComplete = {
                            // Cambiar estado a completada
                        },

                        onCancel = {
                            // Cancelar cita
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )
                }

                item {

                    // BOTÓN FLOTANTE
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        FloatingActionButton(
                            onClick = {},
                            containerColor = Color(0xFF3F82FF),
                            shape = CircleShape
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.Add,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }// FIN LAZY COLUMN

        }// FIN CONTENT

        // FOOTER
        // BOTTOM NAVIGATION
        BusinessBottomNavBar(
            selectedItem = BusinessNavItem.INIT,
            onItemSelected = { item ->

                when(item){
                    BusinessNavItem.PROFILE -> {

                        onNavigateToProfile()
                    }
                    BusinessNavItem.SERVICES -> {

                        onNavigateToService()
                    }

                    else -> {}
                }
            }
        )
    }
}

@Composable
fun WeeklyCalendarCard(

    days: List<DayItem2>,

    onDateSelected: (LocalDate) -> Unit
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(
            2.dp,
            Color(0xFFD9DEE3)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(
                horizontal = 22.dp,
                vertical = 18.dp
            )
        ) {

            // HEADER
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = {}) {

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color(0xFF111827),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(
                    text = "Mayo 2026",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF020817)
                )

                IconButton(onClick = {}) {

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color(0xFF111827),
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            // DAYS ROW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                days.forEach { day ->

                    if(day.selected){

                        SelectedDayItem(

                            day = day,

                            onClick = {

                                onDateSelected(day.date)
                            }
                        )

                    }else{

                        NormalDayItem(

                            day = day,

                            onClick = {

                                onDateSelected(day.date)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SelectedDayItem(
    day: DayItem2,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .width(88.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color(0xFF1290E8))
            .clickable{
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = day.name,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = day.number,
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun NormalDayItem(
    day: DayItem2,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 12.dp)
            .clickable{

                onClick()
            }
    ) {

        Text(
            text = day.name,
            color = Color(0xFF5B6B82),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = day.number,
            color = Color(0xFF020817),
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

data class DayItem2(

    val name: String,

    val number: String,

    val date: LocalDate,

    val selected: Boolean
)
data class CalendarDay(
    val dayName: String,
    val dayNumber: String,
    val selected: Boolean
)
