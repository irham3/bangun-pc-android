package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ScreenTitleText(
    title: String
) {
    Text(
        text = title,
        color = Color.White,
        modifier = Modifier.wrapContentHeight(),
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.h4.copy(
            fontWeight = FontWeight.Medium
        ),
    )
}