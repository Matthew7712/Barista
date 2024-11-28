package com.matthew.matthewcoffix.presantation.common.component.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CustomIcon(
    customIconData: CustomIconData
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(40))
            .background(color = customIconData.backgroundColor)
    ) {
        Icon(
            painter = customIconData.icon,
            contentDescription = "Profile Icon",
            modifier = Modifier.padding(8.dp),
            tint = customIconData.tint
        )
    }
}