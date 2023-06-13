package com.kaizen.bangunpc.ui.screen.auth.login

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kaizen.bangunpc.ui.components.GoogleButton
import com.kaizen.bangunpc.ui.components.ShowHidePasswordTextField
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.DarkOrange
import com.kaizen.bangunpc.ui.theme.Gray
import com.kaizen.bangunpc.utils.rememberImeState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToRegister: (Int) -> Unit
){
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    //  Scroll content when keyboard is shown
    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, animationSpec = tween(250))
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(start = 16.dp, end = 16.dp, top = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = Gray,
                darkIcons = false
            )
        }
        val username = remember { mutableStateOf(TextFieldValue()) }
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Masuk",
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 36.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )
            Text(
                text = "Temukan komponen PC impianmu sekarang",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Masukkan Email Anda") },
            value = username.value,
            shape = RoundedCornerShape(percent = 20),
            onValueChange = { username.value = it }
        )

        Spacer(modifier = Modifier.height(20.dp))
        ShowHidePasswordTextField()

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Masuk",
                fontWeight = FontWeight.Medium,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
        Spacer(modifier = modifier.height(20.dp))
        GoogleButton()
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Belum punya akun? ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )
            ClickableText(
                text = AnnotatedString("Daftar Sekarang"),
                onClick = navigateToRegister,
                style = TextStyle(
                    color = DarkOrange,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun LoginPreview() {
    AppTheme {
        LoginScreen(navigateToRegister = {})
    }
}