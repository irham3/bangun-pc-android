package com.kaizen.bangunpc.ui.screen.auth.register

import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
import androidx.compose.ui.text.input.KeyboardType
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
import com.talhafaki.composablesweettoast.util.SweetToastUtil

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit,
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

    val toastMessage by authViewModel.toastMessageState.collectAsState(initial = MessageState.Loading)
    var fullname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    //  Scroll content when keyboard is shown
    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, animationSpec = tween(250))
        }
    }

    LaunchedEffect(key1 = authViewModel.isAuth.value) {
        if(authViewModel.isAuth.value) {
            navigateToHome()
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(start = 16.dp, end = 16.dp, top = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        toastMessage.let {messageState ->
            when(messageState) {
                MessageState.Loading -> {}
                is MessageState.Warning -> {
                    SweetToastUtil.SweetWarning(
                        message = messageState.warningMessage,
                        duration = Toast.LENGTH_SHORT,
                        padding = PaddingValues(bottom = 16.dp),
                        contentAlignment = Alignment.BottomCenter
                    )
                }
                is MessageState.Error -> {
                    SweetToastUtil.SweetError(
                        message = messageState.errorMessage,
                        duration = Toast.LENGTH_SHORT,
                        padding = PaddingValues(bottom = 16.dp),
                        contentAlignment = Alignment.BottomCenter
                    )
                }
                is MessageState.Success -> {
                    SweetToastUtil.SweetSuccess(
                        message = messageState.successMessage,
                        duration = Toast.LENGTH_SHORT,
                        padding = PaddingValues(bottom = 16.dp),
                        contentAlignment = Alignment.BottomCenter
                    )
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
        Spacer(modifier = modifier.height(20.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Nama Lengkap") },
                value = fullname,
                maxLines = 1,
                shape = RoundedCornerShape(percent = 20),
                onValueChange = { fullname = it }
            )
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Email") },
                value = email,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                shape = RoundedCornerShape(percent = 20),
                onValueChange = { email = it }
            )
            ShowHidePasswordTextField(
                value = password, 
                onValueChange = {password = it}
            )
            ShowHidePasswordTextField(
                value = confirmPassword, 
                onValueChange = {confirmPassword = it},
                label = "Konfirmasi Password"
            )
        }

        Spacer(modifier = modifier.height(20.dp))
        Button(
            onClick = { authViewModel.createUserAccount(email, password, confirmPassword, fullname) },
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            if (authViewModel.isLoading.value) {
                CircularProgressIndicator(color = MaterialTheme.colors.onPrimary)
            } else {
                Text(
                    text = "Daftar",
                    fontWeight = FontWeight.Bold,
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
        Spacer(modifier = modifier.height(20.dp))
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
        RegisterScreen(navigateToLogin = {}, navigateBack = {}, navigateToHome = {})
    }
}