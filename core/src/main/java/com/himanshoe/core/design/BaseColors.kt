package com.himanshoe.core.design

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object BaseColors {
    val primary = Color(0xFF3366FF)
    val background = Color(0xFFFFFFFF)
    val backgroundReverse = Color(0xFF192038)
    val basic = Color(0xFF8F9BB3)
    val disable = basic.copy(alpha = 0.24f)
    val text = Color(0xFF192038)
    val textReverse = Color(0xFFFFFFFF)
    val success = Color(0xFF00E096)
    val link = Color(0xFF0095FF)
    val warning = Color(0xFFFFAA00)
    val error = Color(0xFFFF3D71)
}

interface BaseColorPalette {
    val primary: Color
    val background: Color
    val basic: Color
    val disable: Color
    val text: Color
    val textReverse: Color
    val success: Color
    val link: Color
    val warning: Color
    val error: Color

    val materialColors: Colors
}

fun themeLightColorPalette(): BaseColorPalette = object : BaseColorPalette {
    override val primary: Color = BaseColors.primary
    override val background: Color = BaseColors.background
    override val basic: Color = BaseColors.basic
    override val disable: Color = BaseColors.disable
    override val text: Color = BaseColors.text
    override val textReverse: Color = BaseColors.textReverse
    override val success: Color = BaseColors.success
    override val link: Color = BaseColors.link
    override val warning: Color = BaseColors.warning
    override val error: Color = BaseColors.error

    override val materialColors: Colors = lightColors(
        primary = BaseColors.primary,
        background = BaseColors.background,
        surface = BaseColors.background
    )
}

fun themeDarkColorPalette(): BaseColorPalette = object : BaseColorPalette {
    override val primary: Color = BaseColors.primary
    override val background: Color = BaseColors.backgroundReverse
    override val basic: Color = BaseColors.basic
    override val disable: Color = BaseColors.disable
    override val text: Color = BaseColors.textReverse
    override val textReverse: Color = BaseColors.text
    override val success: Color = BaseColors.success
    override val link: Color = BaseColors.link
    override val warning: Color = BaseColors.warning
    override val error: Color = BaseColors.error

    override val materialColors: Colors = darkColors(
        primary = BaseColors.primary,
        background = BaseColors.backgroundReverse,
        surface = BaseColors.backgroundReverse
    )
}