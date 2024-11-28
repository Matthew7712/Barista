package com.matthew.matthewcoffix.presantation.common.viewmodels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorDot(
    modifier: Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(width = size, height = 3.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(color)
    )
}