package com.matthew.matthewcoffix.ui.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.data.event.UserEvent
import com.matthew.matthewcoffix.data.state.UserState
import com.matthew.matthewcoffix.presantation.common.component.CustomIcon
import com.matthew.matthewcoffix.presantation.common.component.DotSlider
import com.matthew.matthewcoffix.presantation.common.component.SmallButton
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.Orange40
import com.matthew.matthewcoffix.presantation.theme.mediumFirstHeader
import com.matthew.matthewcoffix.presantation.theme.mediumSixthHeader
import com.matthew.matthewcoffix.presantation.theme.regularBasicBody
import com.matthew.matthewcoffix.presantation.theme.regularBigBody
import com.matthew.matthewcoffix.presantation.theme.regularSmallBody
import com.matthew.matthewcoffix.presantation.theme.semiboldThirdHeader

@Composable
fun HomeScreen(
    state: UserState,
    onEvent: (UserEvent) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue100)
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HomeScreenHeader(state = state)
        Spacer(modifier = Modifier.height(20.dp))
        HomeScreenSalesBanner()
        Spacer(modifier = Modifier.height(20.dp))
        HomeScreenMenuList()
        Spacer(modifier = Modifier.height(20.dp))
        HomeScreenMenuList()
    }
}

@Composable
fun HomeScreenHeader(
    state: UserState,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column {
            Text(text = stringResource(id = R.string.home_screen_greeting), style = regularSmallBody.copy(color = Color.Gray))
            Text(text = state.email, style = mediumSixthHeader.copy(color = Color.White))
        }

        CustomIcon(tint = Color.White, backgroundColor = DarkBlue80, icon = painterResource(id = R.drawable.apple))
    }
}

@Composable
fun HomeScreenSalesBanner(){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp
    val screenHeight = screenConfiguration.screenHeightDp

    val sliderHeight = if (screenHeight < 480) screenHeight * 0.25 else if( screenHeight in 481..899) screenHeight * 0.27 else screenHeight * 0.29

    val imageList: List<Painter> = listOf(
        painterResource(id = R.drawable.nathan),
        painterResource(id = R.drawable.kris_atomic_3b2tadgawnu_unsplash),
        painterResource(id = R.drawable.nafinia_putra_kwdp_0pok_i_unsplash),
        painterResource(id = R.drawable.kristaps_grundsteins_tqmxs0ee8b0_unsplash),
    )

    val pager  = rememberPagerState (pageCount = {imageList.size})

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dp(sliderHeight.toFloat()))
            .clip(shape = RoundedCornerShape(15.dp))
    ) {

        HorizontalPager(state = pager) { page ->
            Image(
                painter = imageList[page],
                contentDescription = "Slider Image",
                contentScale = ContentScale.Crop)
        }

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            DotSlider(
                modifier = Modifier,
                totalDots = imageList.size,
                selectedIndex = pager.pageCount,
                selectedColor = Color.White,
                unselectedColor = Color.Gray,
                dotSize = Dp(((screenWidth / imageList.size) - 25).toFloat())
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = stringResource(id = R.string.home_screen_banner_subtitle), style = regularBigBody)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(id = R.string.home_screen_banner_title), style = mediumFirstHeader.copy(fontStyle = FontStyle.Italic))

            Spacer(modifier = Modifier.height(20.dp))

            SmallButton(text = stringResource(id = R.string.home_screen_banner_button_text), onClick = {}, backgroundColor = DarkBlue80, textColor = Color.White)
        }
    }
}

@Composable
fun HomeScreenMenuList(){
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Beverages", style = semiboldThirdHeader.copy(color = Color.White))
            Text(text = "View all", style = regularSmallBody.copy(color = Orange40))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            MenuListPlate(icon = painterResource(id = R.drawable.star), iconColor = Color.Black, text = "Signatured")
            MenuListPlate(icon = painterResource(id = R.drawable.coffee_bean), iconColor = Color.Black, text = "Iced coffee")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            MenuListPlate(icon = painterResource(id = R.drawable.hot_coffee_cup), iconColor = Color.Black, text = "Hot coffee")
            MenuListPlate(icon = painterResource(id = R.drawable.chocolate), iconColor = Color.Black, text = "Chocolate")
        }

        Spacer(modifier = Modifier.height(20.dp))

        SecondHomeScreenMenuList()
    }
}

@Composable
fun SecondHomeScreenMenuList(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Foods", style = semiboldThirdHeader.copy(color = Color.White))
        Text(text = "View all", style = regularSmallBody.copy(color = Orange40))
    }

    Spacer(modifier = Modifier.height(20.dp))

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        MenuListPlate(icon = painterResource(id = R.drawable.star), iconColor = Color.Black, text = "Signatured")
        MenuListPlate(icon = painterResource(id = R.drawable.donut), iconColor = Color.Black, text = "Iced coffee")
    }

    Spacer(modifier = Modifier.height(15.dp))

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        MenuListPlate(icon = painterResource(id = R.drawable.salad), iconColor = Color.Black, text = "Hot coffee")
        MenuListPlate(icon = painterResource(id = R.drawable.yogurt), iconColor = Color.Black, text = "Chocolate")
    }
}

@Composable
fun MenuListPlate(
    icon: Painter,
    iconColor: Color,
    text: String
){
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(Dp(((screenWidth / 2) - 20).toFloat()))
            .clip(shape = RoundedCornerShape(50))
            .background(color = DarkBlue80)
            .padding(8.dp)
    ) {
        CustomIcon(tint = iconColor, backgroundColor = Color.White, icon = icon)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, style = regularBasicBody.copy(color = Color.White))
    }
}