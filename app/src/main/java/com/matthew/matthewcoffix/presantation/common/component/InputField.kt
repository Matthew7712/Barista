package com.matthew.matthewcoffix.presantation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.presantation.theme.DarkBlue80
import com.matthew.matthewcoffix.presantation.theme.mediumSmallBody

@Composable
fun InputField(
    word: String,
    hintText: String,
    onChanged: (String) -> Unit
){
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = word,
        placeholder = {Text(text = hintText, style = mediumSmallBody.copy(color = Color(0xFFAFAFAF)))},
        onValueChange = onChanged,
        maxLines = 1,
        keyboardActions = KeyboardActions (
            onDone = {
                keyboardController?.hide()
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(width = 1.dp, color = Color(0xFF10141B), shape = RoundedCornerShape(15.dp))
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color.Blue),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = DarkBlue80
        )
    )
}