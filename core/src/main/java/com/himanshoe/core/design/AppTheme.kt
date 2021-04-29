package com.himanshoe.core.design

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(
    colors: BaseColorPalette = themeLightColorPalette(),
    typography: BaseTypography = BaseTypography(),
    children: @Composable() () -> Unit
) {
    CompositionLocalProvider(
        LocalDlsColors provides colors,
        LocalDlsTypography provides typography,
    ) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = typography.materialTypography
        ) {
            children()
        }
    }
}

object BaseTheme {
    val colors: BaseColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalDlsColors.current

    val typography: BaseTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDlsTypography.current

    val sizes: BaseSize
        @Composable
        @ReadOnlyComposable
        get() = BaseSize()
}

internal val LocalDlsColors = staticCompositionLocalOf { themeLightColorPalette() }
internal val LocalDlsTypography = staticCompositionLocalOf { BaseTypography() }