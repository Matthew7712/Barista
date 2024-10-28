package com.matthew.matthewcoffix.presantation.common.viewmodels

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.mediumBasicBody
import com.matthew.matthewcoffix.presantation.theme.mediumSmallBody

@Composable
fun BottomNavigationItem(
    activeIndex: Boolean,
    painter: Painter,
    onClick: () -> Unit
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp
    val iconColor by animateColorAsState(targetValue = if (activeIndex) Color.White else Color.Gray)
    val backgroundColor by animateColorAsState(targetValue = if (activeIndex) Color.White else Color.Transparent)

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(Dp(((screenWidth / 4) - 20).toFloat()))
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(50))
            .clickable { onClick() }
    ) {
        Icon(
            painter = painter,
            contentDescription = "Bottom navigation bar icon",
            tint = iconColor
        )
/*        if (activeIndex) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = text, style = mediumSmallBody)
        }*/
    }
}