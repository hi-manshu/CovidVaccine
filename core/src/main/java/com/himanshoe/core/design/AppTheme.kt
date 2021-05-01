package com.himanshoe.core.design

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val ThemeColors = lightColors(
    primary = Black1,
    primaryVariant = Blue,
    onPrimary = Black3,
    secondary = Color.White,
    secondaryVariant = Black3,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = White,
    onBackground = Color.Black,
    surface = Color.White,
)


@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = ThemeColors,
        typography = BaseTypography,
        shapes = BaseShape
    ) {
        content()
    }
}