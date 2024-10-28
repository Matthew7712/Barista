package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CustomIcon(
    tint: Color,
    backgroundColor: Color,
    icon: Painter
){
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(50))
            .background(color = backgroundColor)
    ) {
        Icon(
            painter = icon,
            contentDescription = "Profile Icon",
            modifier = Modifier.padding(6.dp),
            tint = tint
        )
    }
}