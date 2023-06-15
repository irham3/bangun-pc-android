package com.kaizen.bangunpc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    height: Dp = 60.dp,
    padding: Dp = 12.dp,
    content: @Composable (() -> Unit)? = null
) {
    Box(modifier = modifier.shadow(8.dp)) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .background(color = Orange)
                .height(height)
                .padding(padding)
        ){
            if (content != null) content()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
private fun CustomTopBarPreview() {
    AppTheme {
        Scaffold {
            CustomTopBar(
                content = {
                    Row {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = Color.White,
                            contentDescription = stringResource(R.string.back),
                            modifier = Modifier
                                .size(48.dp)
                                .padding(6.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        ScreenTitleText(title = stringResource(R.string.detail_produk))
                    }
                }
            )
        }
    }
}