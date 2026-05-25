package com.app.turny.ui.components.boton

import androidx.compose.foundation.background
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
fun HourButton(
    hour: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .width(84.dp)
            .height(38.dp)
            .border(
                width = 1.dp,
                color = if (selected)
                    Color(0xFF1495F1)
                else
                    Color(0xFFD9D9D9),
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = if (selected)
                    Color(0x141495F1)
                else
                    Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = hour,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = if (selected)
                Color(0xFF1495F1)
            else
                Color.Black
        )
    }
}