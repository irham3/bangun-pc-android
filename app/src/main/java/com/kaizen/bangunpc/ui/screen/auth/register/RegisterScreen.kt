package com.kaizen.bangunpc.ui.screen.auth.register

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: (Int) -> Unit
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Gray,
            darkIcons = false
        )
    }
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
        val username = remember { mutableStateOf(TextFieldValue()) }

        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Daftar",
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
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Nama Lengkap") },
                value = username.value,
                shape = RoundedCornerShape(percent = 20),
                onValueChange = { username.value = it }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Email") },
                value = username.value,
                shape = RoundedCornerShape(percent = 20),
                onValueChange = { username.value = it }
            )
            ShowHidePasswordTextField()
            ShowHidePasswordTextField(label = "Konfirmasi Password")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Daftar",
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        GoogleButton()
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Sudah punya akun? ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )
            ClickableText(
                text = AnnotatedString("Masuk Sekarang"),
                onClick = navigateToLogin,
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
private fun RegisterPreview() {
    AppTheme {
        RegisterScreen(navigateToLogin = {})
    }
}