package com.app.turny.ui.theme

//import androidx.compose.material3.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.turny.R

// Set of Material typography styles to start with
// Archivo: ui/theme/Type.kt

val DMSans = FontFamily(
    Font(R.font.dm_sans, FontWeight.Bold),
    Font(R.font.dm_sans, FontWeight.SemiBold),
    Font(R.font.dm_sans, FontWeight.Normal)
)

val Inter = FontFamily(
    Font(R.font.inter, FontWeight.Normal),
    Font(R.font.inter, FontWeight.Medium),
    Font(R.font.inter, FontWeight.SemiBold)
)

val GeistMono = FontFamily(
    Font(resId = R.font.geist_mono, weight = FontWeight.Normal),
    Font(resId = R.font.geist_mono, weight = FontWeight.Medium),
    Font(resId = R.font.geist_mono, weight = FontWeight.Bold)
)
val Typography = Typography(
    // Títulos (Headings en tu Figma)
    displayLarge = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp, // Correspondiente a 4XL
        lineHeight = 48.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp, // Correspondiente a 2XL
        lineHeight = 32.sp
    ),

    // Texto de cuerpo (Inter en tu Figma)
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp, // Body/Base Regular
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp, // Body/SM Medium
        lineHeight = 20.sp
    ),

    // Código o Datos (Geist Mono en tu Figma)
    labelMedium = TextStyle(
        fontFamily = GeistMono,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp, // Mono/Base
        lineHeight = 20.sp
    )
)