package com.matthew.matthewcoffix.presantation.common.component.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.matthew.matthewcoffix.presantation.theme.semiboldFourthHeader

@Composable
fun ScreenHeader(
    text: String,
    navController: NavController
){
    Box(
        modifier = Modifier.wrapContentSize()
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "This is arrow back icon",
            tint = Color.White,
            modifier = Modifier.fillMaxHeight()
                .align(Alignment.CenterStart)
                .clickable {
                    navController.popBackStack()
                }
        )
        Text(
            textAlign = TextAlign.Center,
            text = text,
            style = semiboldFourthHeader.copy(color = Color.White),
            modifier = Modifier.fillMaxSize()
        )
    }
}