package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.common.component.icons.CustomIcon
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.regularBasicBody
import com.matthew.matthewcoffix.ui.menu.MenuPlate

@Composable
fun Plate(
    plate: MenuPlate
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(Dp(((screenWidth / 2) - 28).toFloat()))
            .clip(shape = RoundedCornerShape(40))
            .background(color = DarkBlue80)
            .padding(8.dp)
    ) {
        CustomIcon(tint = plate.iconColor, backgroundColor = Color.White, icon = painterResource(plate.icon))
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = plate.text, style = regularBasicBody.copy(color = Color.White))
    }
}