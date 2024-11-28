package com.matthew.matthewcoffix.ui.signIn.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.IconButton

@Composable
fun SignInWithPlatform(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(icon = painterResource(id = R.drawable.facebook_f), tint = Color.White, onclick = {})
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(icon = painterResource(id = R.drawable.google), tint = Color.White ,onclick = {})
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(icon = painterResource(id = R.drawable.apple), tint = Color.White, onclick = {})
        Spacer(modifier = Modifier.width(5.dp))
    }
}