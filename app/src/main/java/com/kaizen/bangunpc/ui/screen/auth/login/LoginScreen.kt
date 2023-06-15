package com.kaizen.bangunpc.ui.screen.auth.login

import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.common.MessageState
import com.kaizen.bangunpc.ui.components.ShowHidePasswordTextField
import com.kaizen.bangunpc.ui.screen.auth.AuthViewModel
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.DarkOrange
import com.kaizen.bangunpc.ui.theme.Gray
import com.kaizen.bangunpc.utils.rememberImeState
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetSuccess
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetWarning

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = hiltViewModel(),
    navigateToRegister: (Int) -> Unit,
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit
){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Gray,
            darkIcons = false
        )
    }
    val toastMessage by authViewModel.toastMessageState.collectAsState(initial = MessageState.Loading)
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    //  Scroll content when keyboard is shown
    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, animationSpec = tween(250))
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        toastMessage.let {messageState ->
            when(messageState) {
                MessageState.Loading -> {}
                is MessageState.Warning -> {
                    SweetWarning(message = messageState.warningMessage, duration = Toast.LENGTH_SHORT, padding = PaddingValues(bottom = 16.dp), contentAlignment = Alignment.BottomCenter)
                }
                is MessageState.Error -> {
                    SweetError(message = messageState.errorMessage, duration = Toast.LENGTH_SHORT, padding = PaddingValues(bottom = 16.dp), contentAlignment = Alignment.BottomCenter)
                }
                is MessageState.Success -> {
                    SweetSuccess(message = messageState.successMessage, duration = Toast.LENGTH_SHORT, padding = PaddingValues(bottom = 16.dp), contentAlignment = Alignment.BottomCenter)
                }
            }
        }
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Spacer(modifier = modifier.height(20.dp))
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .size(36.dp)
                    .clickable { navigateBack() }
            )
            Spacer(modifier = modifier.height(20.dp))
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
            maxLines = 1,
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Masukkan Email Anda") },
            value = email,
            shape = RoundedCornerShape(percent = 20),
            onValueChange = { email = it }
        )

        Spacer(modifier = Modifier.height(20.dp))
        ShowHidePasswordTextField(
            value = password,
            onValueChange = {password = it}
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                    authViewModel.loginWithEmail(email, password)
                },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            if (authViewModel.isLoading.value) {
                CircularProgressIndicator(color = MaterialTheme.colors.onPrimary)
            } else {
                Text(
                    text = "Masuk",
                    fontWeight = FontWeight.Medium,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }
        }
//        Spacer(modifier = modifier.height(20.dp))
//        GoogleButton(
//            onClick = authViewModel::loginWithGoogle
//        )
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
    LaunchedEffect(key1 = authViewModel.isAuth.value) {
        if(authViewModel.isAuth.value) {
            navigateToHome()
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
        LoginScreen(navigateToRegister = {}, navigateToHome = {}, navigateBack = {})
    }
}