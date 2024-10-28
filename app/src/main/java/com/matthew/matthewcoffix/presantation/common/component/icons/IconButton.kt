package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80

@Composable
fun IconButton(
    icon: Painter,
    tint: Color,
    onclick: () -> Unit
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp
    val screenHeight = screenConfiguration.screenHeightDp

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(Dp(((screenWidth / 3) - 20).toFloat()))
            .height(56.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(DarkBlue80)
            .clickable {
                onclick()
            }
    ){
      Icon(
          painter = icon,
          contentDescription = "This icon for Button",
          modifier = Modifier.padding(8.dp),
          tint = tint
      )
    }
}