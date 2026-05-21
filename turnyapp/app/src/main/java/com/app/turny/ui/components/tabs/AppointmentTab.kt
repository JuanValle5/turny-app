package com.app.turny.ui.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppointmentTab(

    text: String,

    selected: Boolean,

    onClick: () -> Unit
) {

    Box(

        modifier = Modifier

            .clip(RoundedCornerShape(20.dp))

            .background(

                if(selected)
                    Color(0xFF3B82F6)

                else
                    Color(0xFFE9EDF5)
            )

            .clickable {

                onClick()
            }

            .padding(
                horizontal = 18.dp,
                vertical = 10.dp
            )
    ) {

        Text(

            text = text,

            color =
                if(selected)
                    Color.White

                else
                    Color.DarkGray,

            fontWeight = FontWeight.Medium
        )
    }
}