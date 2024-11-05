package com.matthew.matthewcoffix.presantation.common.component.icons

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.mediumBasicBody
import com.matthew.matthewcoffix.ui.product.components.IconWithText

@Composable
fun CustomIconWithText(
    iconWithText: IconWithText,
    onClick: () -> Unit
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = remember { screenConfiguration.screenWidthDp }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(((screenWidth / 3) - 29).dp)
            .height(((screenWidth / 3) - 29).dp)
            .clip(shape = RoundedCornerShape(Dimensions.RADIUS_50))
            .background(color = iconWithText.backgroundColor)
            .clickable {

            }
    ) {
        Icon(
            painter = iconWithText.icon,
            contentDescription = "Profile Icon",
            tint = iconWithText.tint,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(Dimensions.height10))

        Text(
            text = iconWithText.text,
            style = mediumBasicBody,
        )
    }
}