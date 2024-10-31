package com.matthew.matthewcoffix.ui.menu.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.regularNormalBody

@Composable
fun FoodTypeSwitcher(){
    var activeType by remember { mutableStateOf("Foods") }
    val foodTextColor by animateColorAsState(targetValue = if (activeType == "Foods") Color.Black else Color.Gray)
    val foodBackgroundColor by animateColorAsState(targetValue = if (activeType == "Foods") Color.White else Color.Transparent)
    val drinksTextColor by animateColorAsState(targetValue = if (activeType == "Drinks") Color.Black else Color.Gray)
    val drinksBackgroundColor by animateColorAsState(targetValue = if (activeType == "Drinks") Color.White else Color.Transparent)

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentSize()
            .clip(shape = RoundedCornerShape(40))
            .background(DarkBlue80)
            .padding(10.dp)
    ) {
        Text(
            text = "Foods",
            style = regularNormalBody.copy(color = foodTextColor),
            modifier = Modifier.clip(shape = RoundedCornerShape(30))
                .background(color = foodBackgroundColor)
                .padding(10.dp)
                .clickable { activeType = "Foods" }
        )
        Text(
            text = "Drinks",
            style = regularNormalBody.copy(color = drinksTextColor),
            modifier = Modifier.clip(shape = RoundedCornerShape(30))
                .background(color = drinksBackgroundColor)
                .padding(10.dp)
                .clickable { activeType = "Drinks" }
        )
    }
}