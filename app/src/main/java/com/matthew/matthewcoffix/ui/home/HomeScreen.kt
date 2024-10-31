package com.matthew.matthewcoffix.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.data.event.UserEvent
import com.matthew.matthewcoffix.data.state.UserState
import com.matthew.matthewcoffix.presantation.common.component.MenuCard
import com.matthew.matthewcoffix.presantation.common.component.Plate
import com.matthew.matthewcoffix.presantation.common.component.header.ScreenHeaderWithIcon
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.regularSmallBody
import com.matthew.matthewcoffix.presantation.theme.semiboldThirdHeader
import com.matthew.matthewcoffix.ui.home.components.HomeScreenSalesBanner
import com.matthew.matthewcoffix.ui.menu.MenuItem
import com.matthew.matthewcoffix.ui.menu.MenuPlate

@Composable
fun HomeScreen(
    state: UserState,
    onEvent: (UserEvent) -> Unit
){
    val drinksItem = listOf(
        MenuItem(text = "Kapi Susu Brutai", image = painterResource(R.drawable.nathan), cost = 2.05F),
        MenuItem(text = "Caramel Suntay", image = painterResource(R.drawable.nafinia_putra_kwdp_0pok_i_unsplash), cost = 2.95F),
        MenuItem(text = "Kapi Susu Brutai", image = painterResource(R.drawable.nathan), cost = 2.05F),
        MenuItem(text = "Caramel Suntay", image = painterResource(R.drawable.nafinia_putra_kwdp_0pok_i_unsplash), cost = 2.95F)
    )

    val firstMenuItems = listOf(
        MenuPlate(R.drawable.star, "Signatured", Color.Black),
        MenuPlate(R.drawable.hot_coffee_cup, "Hot Coffee", Color.Black),
        MenuPlate(R.drawable.coffee_bean, "Iced Coffee", Color.Black),
        MenuPlate(R.drawable.chocolate, "Chocolate", Color.Black),
    )

    val secondMenuItems = listOf(
        MenuPlate(R.drawable.star, "Signatured", Color.Black),
        MenuPlate(R.drawable.donut, "Donut", Color.Black),
        MenuPlate(R.drawable.salad, "Salad", Color.Black),
        MenuPlate(R.drawable.yogurt, "Yogurt", Color.Black),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue100)
            .padding(start = 24.dp, end = 24.dp, top = 32.dp)
    ) {
        item {
            ScreenHeaderWithIcon(state = state, icon = painterResource(R.drawable.profile))
            Spacer(modifier = Modifier.height(20.dp))
        }

        item{
            HomeScreenSalesBanner()
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Beverages", style = semiboldThirdHeader.copy(color = Color.White))
                Text(text = "View All", style = regularSmallBody.copy(color = Color.LightGray))
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(firstMenuItems.chunked(2)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach{ item ->
                    Plate(
                        item
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Foods", style = semiboldThirdHeader.copy(color = Color.White))
                Text(text = "View All", style = regularSmallBody.copy(color = Color.LightGray))
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(secondMenuItems.chunked(2)){ items ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items.forEach{ item ->
                    Plate(
                        item
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(drinksItem.chunked(2)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp), // Отступ между элементами
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach { item ->
                    MenuCard(
                        item
                    )
                }
                if (rowItems.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}