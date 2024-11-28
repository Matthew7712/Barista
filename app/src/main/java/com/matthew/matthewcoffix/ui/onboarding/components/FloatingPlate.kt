package com.matthew.matthewcoffix.ui.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.BasicButton

@Composable
fun FloatingPlate(
    navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
            .background(Color(0xB3121212))
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.onboarding_screen_title),
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight(600)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.onboarding_screen_subtitle),
            style = TextStyle(
                color = Color(0xF1ADADAD),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicButton(
            text = stringResource(id = R.string.onboarding_screen_button_text),
            onClick = {
                navController.navigate("Sign In")
            }
        )
    }
}