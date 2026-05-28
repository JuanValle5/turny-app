package com.app.turny.ui.components.cards
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun StatsCardsSection(
    total: Int,
    confirmed: Int,
    pending: Int
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        StatCard(
            modifier = Modifier.weight(1f),
            icon = Icons.Outlined.CalendarMonth,
            iconColor = Color(0xFF0F80D7),
            iconBackground = Color(0xFFEAF4FD),
            number = total.toString(),
            label = "Total"
        )

        StatCard(
            modifier = Modifier.weight(1f),
            icon = Icons.Outlined.CheckCircle,
            iconColor = Color(0xFF10B561),
            iconBackground = Color(0xFFE8F7EF),
            number = confirmed.toString(),
            label = "Confirm."
        )

        StatCard(
            modifier = Modifier.weight(1f),
            icon = Icons.Outlined.AccessTime,
            iconColor = Color(0xFFE0A928),
            iconBackground = Color(0xFFF8F3E7),
            number = pending.toString(),
            label = "Pend."
        )
    }
}