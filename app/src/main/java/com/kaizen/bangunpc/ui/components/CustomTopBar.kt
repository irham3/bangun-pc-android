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
import androidx.compose.ui.draw.shadow
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
    height: Dp = 60.dp,
    topBarBackground: @Composable (() -> Unit) = { DefaultTopBarBackground(height = height) },
    content: @Composable (() -> Unit)? = null
) {
    Box(modifier = modifier.shadow(8.dp)) {
        topBarBackground()
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(8.dp)
        ){
            if (content != null) content()
        }
    }
}

@Composable
private fun DefaultTopBarBackground(
    modifier: Modifier = Modifier,
    height: Dp
) {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "Banner Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(height)
            .fillMaxWidth()
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
private fun CustomTopBarPreview() {
    AppTheme {
        Scaffold {
            CustomTopBar(
                content = { ScreenTitleText(title = "Title") }
            )
        }
    }
}