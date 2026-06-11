package com.app.turny.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlueHard,
    onPrimary = White,

    secondary = PrimaryYellowHard,
    onSecondary = White,

    tertiary = FreshGreen,
    onTertiary = White,

    background = GrayBg,
    onBackground = White,

    surface = DarkText,
    onSurface = White,

    error = RedHard,
    onError = White
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,

    secondary = PrimaryGreen,
    onSecondary = White,

    tertiary = YellowAccent,
    onTertiary = DarkText,

    background = LightBg,
    onBackground = DarkText,

    surface = White,
    onSurface = DarkText,

    error = RedHard,
    onError = White,

    outline = BorderGray
)

@Composable
fun TurnyappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}