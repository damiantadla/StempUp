package com.example.stempup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(OnSignUpClick: (String,String,String,String) -> Unit, navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        NormalTextComponent(value = stringResource(id = R.string.app_name))
        HeadingTextComponent(value = stringResource(id = R.string.register_text))


        Spacer(modifier = Modifier.height(24.dp))


        MyTextField(
            labelValue = stringResource(id = R.string.first_name),
            painterResource(id = R.drawable.baseline_person_24),
            initialValue = firstName,
            onTextChanged = {newFirstName ->
                firstName = newFirstName
            }
        )


        Spacer(modifier = Modifier.height(8.dp))

        MyTextField(
            labelValue = stringResource(id = R.string.last_name),
            painterResource = painterResource(id = R.drawable.baseline_person_24),
            initialValue = lastName,
            onTextChanged = {newLastName ->
                lastName = newLastName
            }
        )
        Spacer(modifier = Modifier.height(24.dp))

        EmailTextField(
            labelValue = stringResource(id = R.string.email),
            painterResource = painterResource(id = R.drawable.baseline_mail_24),
            initialEmail = email,
            onEmailChanged = { newEmail ->
                email = newEmail
            }
        )

        PasswordTextField(
            labelValue = stringResource(id = R.string.password),
            painterResource = painterResource(id = R.drawable.baseline_lock_24),
            initialPassword = password,
            onPasswordChanged = { newPassword ->
                password = newPassword
            }
        )

        Spacer(modifier = Modifier.height(8.dp))



        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier.size(150.dp, 55.dp),
            onClick = {
                OnSignUpClick(email, password, firstName, lastName)
            }){
            Text(
                fontSize = 16.sp,
                text = "Register" )
        }

        Spacer(modifier = Modifier.height(100.dp))


        Row(){
            Text(text="Already have an account? ", fontSize = 16.sp)
            ClickableText(
                onClick = {navController.navigate("login")},
                text= AnnotatedString(text = "Login" ),
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = primaryColor
                )
            )
        }


    }
}