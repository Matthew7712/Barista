package com.matthew.matthewcoffix.ui.signUp

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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.data.event.UserEvent
import com.matthew.matthewcoffix.data.state.UserState
import com.matthew.matthewcoffix.presantation.common.component.BasicButton
import com.matthew.matthewcoffix.presantation.common.component.input.InputFields
import com.matthew.matthewcoffix.presantation.theme.DarkBlue100
import com.matthew.matthewcoffix.presantation.theme.Dimensions
import com.matthew.matthewcoffix.presantation.theme.regularNormalBody
import com.matthew.matthewcoffix.presantation.theme.semiBoldFirstHeader
import com.matthew.matthewcoffix.ui.signIn.components.SignInWithPlatform

@Composable
fun SignUp(
    navController: NavController,
    onEvent: (UserEvent) -> Unit,
    state: UserState
){
    var userEmail by remember {
        mutableStateOf("")
    }

    var userPassword by remember {
        mutableStateOf("")
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue100)
            .padding(horizontal = Dimensions.width24, vertical = Dimensions.height32)
    ) {
        item {
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
        }

        item{
            Spacer(modifier = Modifier.height(Dimensions.height30))
        }

        item {
            Text(
                text = stringResource(R.string.sign_up_screen_title),
                style = semiBoldFirstHeader.copy(color = Color.White)
            )
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height25))
        }
        item {
            InputFields(
                email = userEmail,
                password = userPassword,
                onEmailChanged = { newEmail -> userEmail = newEmail },
                onPasswordChanged = { newPassword -> userPassword = newPassword }
            )
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height25))
        }

        item {
            BasicButton(text = stringResource(id = R.string.sign_in_screen_button_text), onClick = {
                onEvent(UserEvent.AddUser(email = userEmail.trim(), password = userPassword.trim()))
            })
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height25))
        }

        item {
            SignInWithPlatform()
        }

        item {
            Spacer(modifier = Modifier.height(Dimensions.height25))
        }

        item {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up_screen_register_text),
                    style = regularNormalBody.copy(color = Color.White),
                    modifier = Modifier.clickable { navController.navigate("Sign Up") }
                )
            }
        }
    }
}