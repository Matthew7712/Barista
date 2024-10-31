package com.matthew.matthewcoffix.ui.menu.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.Plate
import com.matthew.matthewcoffix.ui.menu.MenuPlate

@Composable
fun MenuTypeSlider(){
    val menuItems = listOf(
        MenuPlate(icon = R.drawable.star, text = "Signatured", iconColor =  Color.Black),
        MenuPlate(icon = R.drawable.hot_coffee_cup, text ="Hot Coffee", iconColor =  Color.Black),
        MenuPlate(icon = R.drawable.coffee_bean, text = "Iced Coffee", iconColor =  Color.Black),
        MenuPlate(icon = R.drawable.chocolate, text = "Chocolate", iconColor =  Color.Black),
    )

    LazyRow {
        itemsIndexed(menuItems) {index, item ->
            Plate(
                item
            )
            if (index != menuItems.lastIndex){
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}
