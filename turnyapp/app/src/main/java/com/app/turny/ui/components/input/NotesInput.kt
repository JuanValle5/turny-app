package com.app.turny.ui.components.input

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotesInput(
    value: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp),
        placeholder = {
            Text(
                text = "Alguna indicación especial...",
                color = Color(0xFFA0A0A0),
                fontSize = 13.sp
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF1495F1),
            unfocusedBorderColor = Color(0xFFD9D9D9),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}