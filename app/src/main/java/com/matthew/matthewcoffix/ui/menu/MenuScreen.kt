package com.matthew.matthewcoffix.ui.menu

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.MenuCard
import com.matthew.matthewcoffix.presantation.common.component.header.ScreenHeader
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.ui.menu.components.FoodTypeSwitcher
import com.matthew.matthewcoffix.ui.menu.components.MenuTypeSlider

@Composable
fun MenuScreen(
    navController: NavController
){
    val nathanImage = painterResource(R.drawable.nathan)
    val caramelImage = painterResource(R.drawable.nafinia_putra_kwdp_0pok_i_unsplash)

    val drinksItem = listOf(
        MenuItem(text = "Kapi Susu Brutai", image = nathanImage, cost = 2.05F),
        MenuItem(text = "Caramel Suntay", image = caramelImage, cost = 2.95F),
        MenuItem(text = "Kapi Susu Brutai", image = nathanImage, cost = 2.05F),
        MenuItem(text = "Caramel Suntay", image = caramelImage, cost = 2.95F),
        MenuItem(text = "Kapi Susu Brutai", image = nathanImage, cost = 2.05F),
        MenuItem(text = "Caramel Suntay", image = caramelImage, cost = 2.95F),
        MenuItem(text = "Kapi Susu Brutai", image = nathanImage, cost = 2.05F),
        MenuItem(text = "Caramel Suntay", image = caramelImage, cost = 2.95F)
    )

    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(DarkBlue100)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
    ) {
        item {
            ScreenHeader("Menu", navController = navController)
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            FoodTypeSwitcher()
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            MenuTypeSlider()
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        items(drinksItem.chunked(2)){ items ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items.forEach{ item ->
                    MenuCard(menuItem = remember { item })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

