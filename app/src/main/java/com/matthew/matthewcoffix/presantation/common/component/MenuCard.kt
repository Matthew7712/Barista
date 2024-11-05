package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.mediumSmallBody
import com.matthew.matthewcoffix.presantation.theme.regularBasicBody
import com.matthew.matthewcoffix.ui.menu.MenuItem

@Composable
fun MenuCard(
    menuItem: MenuItem,
    navController: NavController
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp
    val screenHeight = screenConfiguration.screenHeightDp

    Box(
        modifier = Modifier
            .width(Dp(((screenWidth / 2) - 34).toFloat()))
            .height(Dp(((screenHeight / 3) - 60).toFloat()))
            .clip(shape = RoundedCornerShape(Dimensions.RADIUS_20))
            .clickable {
                navController.navigate("Product/${menuItem.id}")
            }
    ) {
        Image(
            painter = painterResource(menuItem.image),
            contentDescription = "This is background image for menu card",
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth()
                .height(Dp(((screenHeight / 3) - 60).toFloat()))
                .padding(horizontal = Dimensions.width10, vertical = Dimensions.height15)
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(Dimensions.RADIUS_50))
                    .background(color = Color.White)
            ){
                Text(
                    text = "$${menuItem.cost}",
                    style = mediumSmallBody.copy(color = Color.Black),
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Text(
                text = menuItem.text,
                textAlign = TextAlign.Left,
                style = regularBasicBody.copy(color = Color.White),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}
