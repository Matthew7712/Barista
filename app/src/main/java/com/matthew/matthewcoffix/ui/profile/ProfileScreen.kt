package com.matthew.matthewcoffix.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.header.ScreenHeader
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.mediumSixthHeader
import com.matthew.matthewcoffix.presantation.theme.regularNormalBody
import com.matthew.matthewcoffix.presantation.theme.regularSmallBody

@Preview
@Composable
fun ProfileScreen(){
    val navController: NavController = rememberNavController()
    val firstSettingPlates: List<PlateData> = listOf(
        PlateData(
            icon = painterResource(R.drawable.profile),
            iconColor = Color.White,
            text = "Additional Settings"
        ),
        PlateData(
            icon = painterResource(R.drawable.settings_icon),
            iconColor = Color.White,
            text = "Additional Settings"
        ),
    )

    val secondSettingPlates: List<PlateData> = listOf(
        PlateData(
            icon = painterResource(R.drawable.support_icon),
            iconColor = Color.White,
            text = "Support"
        ),
        PlateData(
            icon = painterResource(R.drawable.about_icon),
            iconColor = Color.White,
            text = "About"
        ),
        PlateData(
            icon = painterResource(R.drawable.log_out_icon),
            iconColor = Color.White,
            text = "Log out"
        ),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(DarkBlue100)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
    ) {
        item {
            ScreenHeader("Profile", navController = navController)
        }

        item{
            Spacer(modifier = Modifier.height(50.dp))
        }

        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.nathan),
                    contentDescription = "Profile image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(121.dp)
                        .clip(shape = CircleShape)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Matthew Rusakovich",
                    style = mediumSixthHeader.copy(color = Color.LightGray)
                )
                Text(
                    text = "mgkct@gmail.com",
                    style = regularSmallBody.copy(color = Color.White)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        items(firstSettingPlates) { item ->
            Plate(item)
            Spacer(modifier = Modifier.height(Dimensions.height10))
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height20))
        }

        item {
            Divider(
                color = Color.DarkGray,
                modifier = Modifier.height(3.dp)
                    .clip(shape = RoundedCornerShape(5))
            )
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height30))
        }

        items(secondSettingPlates){item ->
            Plate(item)
            Spacer(modifier = Modifier.height(Dimensions.height10))
        }
    }
}

@Composable
fun Plate(
    plateData: PlateData
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(Dimensions.RADIUS_30))
            .clip(shape = RoundedCornerShape(Dimensions.RADIUS_30))
            .background(color = Color.Transparent)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Icon(
            painter = plateData.icon,
            contentDescription = "",
            tint = plateData.iconColor
        )
        Spacer(modifier = Modifier.width(Dimensions.width20))
        Text(
            text = plateData.text,
            style = regularNormalBody.copy(color = Color.White)
        )
    }
}

data class PlateData(
    val icon: Painter,
    val iconColor: Color,
    val text: String
)