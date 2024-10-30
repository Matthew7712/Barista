package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.viewmodels.BottomNavigationItem
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80

@Composable
fun BottomNavigationBar(){
    var activeIndex by remember {
        mutableStateOf(1)
    }

    BottomAppBar(
        containerColor = Color.Transparent,
        modifier = Modifier.background(color = DarkBlue100)
            .padding(horizontal = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .height(70.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = DarkBlue80)
                .padding(horizontal = 24.dp)
        ) {
            BottomNavigationItem(activeIndex = activeIndex == 1, painter = painterResource(id = R.drawable.search), onClick = {activeIndex = 1})
            BottomNavigationItem(activeIndex = activeIndex == 2, painter = painterResource(id = R.drawable.home), onClick = {activeIndex = 2})
            BottomNavigationItem(activeIndex = activeIndex == 3, painter = painterResource(id = R.drawable.cart), onClick = {activeIndex = 3})
            BottomNavigationItem(activeIndex = activeIndex == 4, painter = painterResource(id = R.drawable.profile), onClick = {activeIndex = 4})
        }
    }
}