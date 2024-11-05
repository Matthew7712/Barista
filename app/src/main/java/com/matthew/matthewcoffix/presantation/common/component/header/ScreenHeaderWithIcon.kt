package com.matthew.matthewcoffix.presantation.common.component.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.data.state.UserState
import com.matthew.matthewcoffix.presantation.common.component.icons.CustomIcon
import com.matthew.matthewcoffix.presantation.common.component.icons.CustomIconData
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.mediumSixthHeader
import com.matthew.matthewcoffix.presantation.theme.regularSmallBody

@Composable
fun ScreenHeaderWithIcon(
    state: UserState,
    icon: Painter
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

        CustomIcon(CustomIconData(tint = Color.White, backgroundColor = DarkBlue80, icon = icon))
    }
}