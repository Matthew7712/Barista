package com.matthew.matthewcoffix.ui.product.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.regularBasicBody

@Preview
@Composable
fun BottomCounter(){
    var amount by remember{ mutableIntStateOf(1) }

    Column(
        modifier = Modifier.clip(shape = RoundedCornerShape(Dimensions.RADIUS_20))
            .background(color = DarkBlue100)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .height(85.dp)
                .clip(shape = RoundedCornerShape(Dimensions.RADIUS_25))
                .background(color = DarkBlue80)
                .padding(horizontal = 24.dp)
        ) {
            CircleButton(
                icon = painterResource(R.drawable.add_icon),
                color = Color.LightGray,
                onClick = { amount++ }
            )
            Text(
                text = amount.toString(),
                style = regularBasicBody.copy(color = Color.White)
            )
            CircleButton(
                icon = painterResource(R.drawable.remove_icon),
                color = Color.LightGray,
                onClick = {if (amount > 1) amount++ }
            )
        }
    }
}

fun increaseValue(amount: MutableState<Int>){
    amount.value++
}

fun decreaseValue(amount: MutableState<Int>){
    if (amount.value >= 2){
        amount.value++
    } else{
        amount.value += 0
    }
}

@Composable
fun CircleButton(
    icon: Painter,
    color: Color,
    onClick: () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
            .width(32.dp)
            .height(32.dp)
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(Dimensions.RADIUS_50))
            .clickable {
                onClick()
            }
    ) {
        Icon(
            painter = icon,
            contentDescription = "Button icon",
            tint = color
        )
    }
}