package com.matthew.matthewcoffix.ui.product

import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.data.viewmodel.ProductViewModel
import com.matthew.matthewcoffix.presantation.common.component.buttons.circleButton.CircleButton
import com.matthew.matthewcoffix.presantation.common.component.buttons.circleButton.CircleButtonData
import com.matthew.matthewcoffix.presantation.common.component.icons.CustomIconWithText
import com.matthew.matthewcoffix.presantation.common.component.input.InputField
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.regularBasicBody
import com.matthew.matthewcoffix.presantation.theme.regularNormalBody
import com.matthew.matthewcoffix.presantation.theme.semiBoldFirstHeader
import com.matthew.matthewcoffix.presantation.theme.semiboldFourthHeader
import com.matthew.matthewcoffix.ui.product.components.AddToBagButton
import com.matthew.matthewcoffix.ui.product.components.IconWithText

@Composable
fun Product(
    navController: NavController,
    id: Int,
    viewModel: ProductViewModel
){
    var plateIsActive by remember { mutableStateOf("Basic") }
    val basicColor: Color = if (plateIsActive == "Basic"){ Color.Blue } else Color.White
    val mediumColor: Color = if (plateIsActive == "Medium"){ Color.Blue} else Color.White
    val largeColor: Color = if(plateIsActive == "Large"){Color.Blue} else Color.White

    val drinkSize: List<IconWithText> = listOf(
        IconWithText(tint = Color.Black, text = "Basic", icon = painterResource(R.drawable.coffee_cup), backgroundColor = basicColor),
        IconWithText(tint = Color.Black, text = "Medium", icon = painterResource(R.drawable.coffee_cup), backgroundColor = mediumColor),
        IconWithText(tint = Color.Black, text = "Large", icon = painterResource(R.drawable.coffee_cup), backgroundColor = largeColor)
    )

    val toppingList: List<String> = listOf(
        "Boba",
        "Almond",
        "Cheese",
        "Oat"
    )

    val item = viewModel.getItemById(id)

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxSize()
            .background(color = DarkBlue100)
    ){
        Box(){
            Text(
                text = item!!.text,
                style = semiBoldFirstHeader.copy(color = Color.White)
            )
            CustomBottomPlate(drinkSize = drinkSize, toppingList = toppingList, plateIsActive = plateIsActive, onClick = {plateIsActive = it})
        }
        BottomCounter()
    }
}

@Composable
fun CustomBottomPlate(
    drinkSize: List<IconWithText>,
    toppingList: List<String>,
    plateIsActive: String,
    onClick: (String) -> Unit
){
    val screenConfiguration = LocalConfiguration.current
    val screenHeight = remember { screenConfiguration.screenHeightDp }
    var req by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
            .height((screenHeight * 0.65).dp)
            .clip(shape = RoundedCornerShape(topStartPercent = Dimensions.RADIUS_10, topEndPercent = Dimensions.RADIUS_10))
            .background(color = DarkBlue80)
            .padding(vertical = Dimensions.height20, horizontal = Dimensions.width20)
    ) {
        item {
            Text(
                text = "Drink size",
                style = semiboldFourthHeader.copy(color = Color.White)
            )
        }

        item { 
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        items(drinkSize.chunked(3)){items ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimensions.width20)
            ) {
                drinkSize.forEach{ item ->
                    CustomIconWithText(item, onClick = {onClick(plateIsActive)})
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            Text(
                text = "Toppings",
                style = semiboldFourthHeader.copy(color = Color.White)
            )
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            ToppingsHorizontalSlider(toppingList = toppingList)
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            Text(
                text = "Additional Req",
                style = semiboldFourthHeader.copy(color = Color.White)
            )
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            InputField(
                word = req,
                hintText = "Enter your additional req",
                onChanged = {newString -> req = newString},
                isPassword = false
            )
        }
    }
}

@Composable
fun ToppingsHorizontalSlider(
    toppingList: List<String>
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = remember { screenConfiguration.screenWidthDp }

    LazyRow {
        items(toppingList.mapIndexed { index, txt -> Pair(txt, index) }) { (txt, index) ->
            Text(
                text = txt,
                style = regularBasicBody,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width((screenWidth / 4).dp)
                    .clip(shape = RoundedCornerShape(Dimensions.RADIUS_50))
                    .background(color = Color.White)
                    .padding(horizontal = 6.dp, vertical = 12.dp)
            )
            if (index != toppingList.lastIndex) {
                Spacer(modifier = Modifier.width(Dimensions.width5))
            }
        }
    }
}

@Composable
fun BottomCounter(){
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(80.dp)
            .clip(shape = RoundedCornerShape(topStartPercent = Dimensions.RADIUS_25, topEndPercent = Dimensions.RADIUS_25))
            .background(color = Color.DarkGray)
            .padding(horizontal = Dimensions.width24, vertical = Dimensions.height15)
    ) {
        Counter()
        Spacer(modifier = Modifier.width(Dimensions.width10))
        AddToBagButton()
    }
}

@Composable
fun Counter(){
    var amount by remember { mutableStateOf(0) }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleButton(
            CircleButtonData(
                backgroundColor = Color.Transparent,
                iconColor = Color.LightGray,
                icon = painterResource(R.drawable.add_icon),
                onClick = {amount++}
            )
        )

        Spacer(modifier = Modifier.width(Dimensions.width20))

        Text(
            text = amount.toString(),
            style = regularNormalBody.copy(color = Color.LightGray)
        )

        Spacer(modifier = Modifier.width(Dimensions.width20))

        CircleButton(
            CircleButtonData(
                backgroundColor = Color.Transparent,
                iconColor = Color.LightGray,
                icon = painterResource(R.drawable.remove_icon),
                onClick = {if (amount > 1) amount--}
            )
        )
    }
}
