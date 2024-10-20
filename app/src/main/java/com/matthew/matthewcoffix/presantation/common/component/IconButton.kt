package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    icon: Painter,
    onclick: () -> Unit
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp
    val screenHeight = screenConfiguration.screenHeightDp

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(Dp(((screenWidth / 3) - 20).toFloat()))
            .clickable {
                onclick()
            }
    ){
      Icon(
          painter = icon,
          contentDescription = "This icon for Button",
          modifier = Modifier.padding(8.dp)
      )
    }
}