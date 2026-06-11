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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconColor: Color,
    iconBackground: Color,
    number: String,
    label: String
) {

    Card(
        modifier = modifier
            .height(190.dp),
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
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Box(
                modifier = Modifier
                    .size(74.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(iconBackground),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.size(34.dp)
                )
            }

            Text(
                text = number,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF020817)
            )

            Text(
                text = label,
                fontSize = 14.sp,
                color = Color(0xFF4A5D7A),
                maxLines = 2,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
