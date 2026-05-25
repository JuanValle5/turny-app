package com.app.turny.ui.components.boton

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DateButton(
    dayName: String,
    dayNumber: String,
    month: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    val borderColor =
        if (selected) Color(0xFF4AA8FF)
        else Color(0xFFD9D9D9)

    val textColor =
        if (selected) Color(0xFF1495F1)
        else Color(0xFF7B7B7B)

    Box(
        modifier = Modifier
            .width(58.dp)
            .height(82.dp)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = dayName,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = dayNumber,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = if (selected) Color(0xFF1495F1) else Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = month,
                fontSize = 11.sp,
                color = Color(0xFF7B7B7B)
            )
        }
    }
}