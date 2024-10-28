package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.mediumNormalBody

@Composable
fun SmallButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(Dp((screenWidth / 3).toFloat()))
            .height(56.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = backgroundColor)
            .clickable {
                onClick()
            }
    ) {
        Text(text = text, style = mediumNormalBody.copy(color = textColor))
    }
}