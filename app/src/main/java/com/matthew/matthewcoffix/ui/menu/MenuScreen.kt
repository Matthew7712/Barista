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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.data.viewmodel.ProductViewModel
import com.matthew.matthewcoffix.presantation.common.component.MenuCard
import com.matthew.matthewcoffix.presantation.common.component.header.ScreenHeader
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.ui.menu.components.FoodTypeSwitcher
import com.matthew.matthewcoffix.ui.menu.components.MenuTypeSlider

@Composable
fun MenuScreen(
    navController: NavController
){
    val nathanImage = painterResource(R.drawable.nathan)
    val caramelImage = painterResource(R.drawable.nafinia_putra_kwdp_0pok_i_unsplash)

    val productViewModel: ProductViewModel = remember { ProductViewModel() }
    val productList by productViewModel.items.observeAsState(emptyList())

    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(DarkBlue100)
            .padding(start = Dimensions.width24, top = Dimensions.height24, end = Dimensions.width24)
    ) {
        item {
            ScreenHeader("Menu", navController = navController)
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            FoodTypeSwitcher()
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height15))
        }

        item {
            MenuTypeSlider()
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        items(productList.chunked(2)){ items ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimensions.width20),
                modifier = Modifier.fillMaxWidth()
            ) {
                items.forEach{ item ->
                    MenuCard(menuItem = remember { item }, navController)
                }
            }

            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

