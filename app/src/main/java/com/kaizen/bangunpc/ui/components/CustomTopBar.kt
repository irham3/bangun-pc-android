package com.kaizen.bangunpc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.theme.AppTheme

@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    height: Dp = 50.dp,
    content: @Composable (() -> Unit)? = null
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(height)
                .fillMaxWidth()
        )

        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(8.dp)
        ){
            if (content != null) content()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun CustomTopBarPreview() {
    AppTheme {
        Scaffold {
            CustomTopBar(
                content = { ScreenTitleText(title = "Judul") }
            )
        }
    }
}