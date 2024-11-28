package com.matthew.matthewcoffix.presantation.common.component.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.matthew.matthewcoffix.R

@Composable
fun InputFields(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit
){
    Column {
        InputField(word = email, hintText = stringResource(R.string.sign_in_screen_email_input_field), onChanged = onEmailChanged, isPassword = false)
        Spacer(modifier = Modifier.height(10.dp))
        InputField(word = password, hintText = stringResource(R.string.sign_in_screen_password_input_field), onChanged = onPasswordChanged, isPassword = true)
    }
}