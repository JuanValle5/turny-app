package com.app.turny.ui.business


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.BusinessBottomNavBar
import com.app.turny.ui.components.BusinessNavItem
import com.app.turny.ui.components.cards.AppointmentBusinessCard
import com.app.turny.ui.components.cards.AppointmentStatus
import com.app.turny.ui.components.cards.StatsCardsSection
import com.app.turny.ui.components.structure.AppHeader

@Composable
fun HomeBusinessScreen2(
    onNavigateToProfile: () -> Unit,
    viewModel: HomeBusinessViewModel =
        viewModel()
    //viewModel: BusinessViewModel = viewModel()
) {

    val uiState by
    viewModel.uiState.collectAsState()

    val weekDays = listOf(
        CalendarDay("mraz", "2", false),
        CalendarDay("Mar", "3", false),
        CalendarDay("Mié", "4", false),
        CalendarDay("Jue", "5", true),
        CalendarDay("Vie", "6", false),
        CalendarDay("Sáb", "7", false),
        CalendarDay("Dom", "8", false)
    )

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

                    Text(
                        text = "Jueves, 5 de febrero",
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
                    WeeklyCalendarCard()
                }

                item {
                    // TÍTULO CITAS
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Citas - hoy",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "5 citas",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }

                item {

                    AppointmentBusinessCard(
                        serviceName = "Corte de cabello",
                        clientName = "Laura Torres",
                        hour = "09:00",
                        duration = "30 min",
                        status = AppointmentStatus.PENDING
                    )

                    AppointmentBusinessCard(
                        serviceName = "Barba Premium",
                        clientName = "Carlos Ruiz",
                        hour = "11:30",
                        duration = "45 min",
                        status = AppointmentStatus.COMPLETED
                    )

                    AppointmentBusinessCard(
                        serviceName = "Tintura",
                        clientName = "Ana Gómez",
                        hour = "02:00",
                        duration = "1 hora",
                        status = AppointmentStatus.CONFIRMED
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
                    else -> {}
                }
            }
        )
    }
}

@Composable
fun WeeklyCalendarCard() {

    val days = listOf(
        DayItem2("LUN", "25", true),
        DayItem2("MAR", "26", false),
        DayItem2("MIÉ", "27", false),
        DayItem2("JUE", "28", false),
        DayItem2("VIE", "29", false),
        DayItem2("SÁB", "30", false),
        DayItem2("DOM", "31", false)
    )

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

                    if (day.selected) {

                        SelectedDayItem(day)

                    } else {

                        NormalDayItem(day)
                    }
                }
            }
        }
    }
}

@Composable
fun SelectedDayItem(day: DayItem2) {

    Column(
        modifier = Modifier
            .width(88.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color(0xFF1290E8)),
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
fun NormalDayItem(day: DayItem2 ) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 12.dp)
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
    val selected: Boolean
)
data class CalendarDay(
    val dayName: String,
    val dayNumber: String,
    val selected: Boolean
)
