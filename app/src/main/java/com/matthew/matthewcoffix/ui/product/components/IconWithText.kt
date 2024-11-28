package com.matthew.matthewcoffix.ui.product.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class IconWithText(
    val tint: Color,
    val backgroundColor: Color,
    val icon: Painter,
    val text: String
)
