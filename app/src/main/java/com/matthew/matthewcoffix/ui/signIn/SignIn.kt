package com.matthew.matthewcoffix.ui.signIn

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.presantation.common.component.BasicButton
import com.matthew.matthewcoffix.presantation.common.component.IconButton
import com.matthew.matthewcoffix.presantation.common.component.InputField
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.Orange40
import com.matthew.matthewcoffix.presantation.theme.regularNormalBody
import com.matthew.matthewcoffix.presantation.theme.semiBoldFirstHeader

@Composable
fun SignIn(
    navController: NavController
){
    var userEmail by remember {
        mutableStateOf("")
    }

    var userPassword by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue100)
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(R.drawable.cup_of_coffee),
                contentDescription = "Sign In header icon",
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = stringResource(R.string.sign_in_screen_title),
            style = semiBoldFirstHeader.copy(color = Color.White)
        )

        Spacer(modifier = Modifier.height(25.dp))

        InputFields(
            email = userEmail,
            password = userPassword,
            onEmailChanged = { newEmail -> userEmail = newEmail },
            onPasswordChanged = { newPassword -> userPassword = newPassword }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.sign_in_screen_forgot_password_text), style = regularNormalBody.copy(color = Orange40))
        }

        Spacer(modifier = Modifier.height(25.dp))

        BasicButton(text = stringResource(id = R.string.sign_in_screen_button_text), onClick = {navController.navigate("Home")})

        Spacer(modifier = Modifier.height(25.dp))

        SignInWithPlatform()

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.sign_in_screen_register_text),
                style = regularNormalBody.copy(color = Color.White),
                modifier = Modifier.clickable { navController.navigate("Sign Up") }
            )
        }

    }
}

@Composable
fun InputFields(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit
){
    Column {
        InputField(word = email, hintText = stringResource(R.string.sign_in_screen_email_input_field), onChanged = onEmailChanged)
        Spacer(modifier = Modifier.height(10.dp))
        InputField(word = password, hintText = stringResource(R.string.sign_in_screen_password_input_field), onChanged = onPasswordChanged)
    }
}

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