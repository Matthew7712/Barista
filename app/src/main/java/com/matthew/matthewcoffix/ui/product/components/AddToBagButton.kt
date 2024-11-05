package com.matthew.matthewcoffix.ui.product.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.mediumNormalBody
import com.matthew.matthewcoffix.presantation.theme.mediumSmallBody

@Composable
fun AddToBagButton(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(48.dp)
            .clip(shape = RoundedCornerShape(Dimensions.RADIUS_40))
            .background(color = Color.Blue)
            .padding(horizontal = Dimensions.width15)
    ) {
        Text(
            text = "Add to bag",
            style = mediumSmallBody.copy(color = Color.LightGray)
        )

        Text(
            text = "$2,95",
            style = mediumNormalBody.copy(color = Color.LightGray)
        )
    }
}