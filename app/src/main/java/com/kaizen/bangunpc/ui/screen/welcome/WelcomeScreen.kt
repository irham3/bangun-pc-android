package com.kaizen.bangunpc.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit,
    navigateToHome: (Int) -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Orange,
            darkIcons = false
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Orange)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .padding(bottom = 20.dp)
                .height(200.dp),
            contentDescription = "Logo Bangun PC"
        )
        Column(modifier.fillMaxWidth()) {
            Text(
                text = "Selamat Datang di\nBangun PC",
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )
            Text(
                text = "Temukan komponen PC impianmu sekarang",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = navigateToLogin,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Masuk",
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = navigateToRegister,
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
        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            ClickableText(
                text = AnnotatedString("Lewati Langkah ini"),
                onClick = navigateToHome,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Default
                )
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun Preview() {
    AppTheme {
        WelcomeScreen(
            navigateToHome = {},
            navigateToLogin = {},
            navigateToRegister = {}
        )
    }
}