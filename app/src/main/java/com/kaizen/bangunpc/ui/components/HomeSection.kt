package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SectionText(title, modifier)
            Text(
                modifier = modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                text = "Lihat Semua",
                style = MaterialTheme.typography.subtitle2,

            )
        }
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            content()
        }
        Spacer(modifier = modifier.height(8.dp))
    }
}