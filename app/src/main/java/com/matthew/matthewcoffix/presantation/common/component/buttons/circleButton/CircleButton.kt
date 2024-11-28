package com.matthew.matthewcoffix.presantation.common.component.buttons.circleButton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CircleButton(
    circleButtonData: CircleButtonData
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(48.dp)
            .height(48.dp)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .background(circleButtonData.backgroundColor)
            .padding(6.dp)
            .clickable {
                circleButtonData.onClick()
            }
    ) {
        Icon(
            painter = circleButtonData.icon,
            contentDescription = "This is icon for button",
            tint = circleButtonData.iconColor,
            modifier = Modifier.size(width = 36.dp, height = 36.dp)
        )
    }
}

data class CircleButtonData(
    val backgroundColor: Color,
    val iconColor: Color,
    val icon: Painter,
    val onClick: () -> Unit
)