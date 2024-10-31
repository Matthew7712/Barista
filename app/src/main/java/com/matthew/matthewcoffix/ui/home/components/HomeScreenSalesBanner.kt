package com.matthew.matthewcoffix.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.DotSlider
import com.matthew.matthewcoffix.presantation.common.component.SmallButton
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.mediumFirstHeader
import com.matthew.matthewcoffix.presantation.theme.regularBigBody

@Composable
fun HomeScreenSalesBanner() {
    val screenConfiguration = LocalConfiguration.current
    val screenWidth = screenConfiguration.screenWidthDp
    val screenHeight = screenConfiguration.screenHeightDp

    val sliderHeight = when {
        screenHeight < 480 -> screenHeight * 0.25
        screenHeight in 481..899 -> screenHeight * 0.27
        else -> screenHeight * 0.29
    }

    val imageList: List<Painter> = listOf(
        painterResource(id = R.drawable.nathan),
        painterResource(id = R.drawable.kris_atomic_3b2tadgawnu_unsplash),
        painterResource(id = R.drawable.nafinia_putra_kwdp_0pok_i_unsplash),
        painterResource(id = R.drawable.kristaps_grundsteins_tqmxs0ee8b0_unsplash),
    )

    val pager = rememberPagerState(pageCount = { imageList.size })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(sliderHeight.dp)
            .clip(shape = RoundedCornerShape(15.dp))
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Пространство между изображениями
        ) {
            items(imageList.size) { page ->
                Image(
                    painter = imageList[page],
                    contentDescription = "Slider Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(sliderHeight.dp)
                        .clip(RoundedCornerShape(15.dp))
                )
            }
        }

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            DotSlider(
                totalDots = imageList.size,
                selectedIndex = pager.currentPage,
                selectedColor = Color.White,
                unselectedColor = Color.Gray,
                modifier = Modifier,
                dotSize = ((screenWidth / imageList.size) - 25).dp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.home_screen_banner_subtitle),
                style = regularBigBody
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.home_screen_banner_title),
                style = mediumFirstHeader.copy(fontStyle = FontStyle.Italic)
            )

            Spacer(modifier = Modifier.height(20.dp))

            SmallButton(
                text = stringResource(id = R.string.home_screen_banner_button_text),
                onClick = {},
                backgroundColor = DarkBlue80,
                textColor = Color.White
            )
        }
    }
}