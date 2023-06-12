package com.kaizen.bangunpc.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun TextChip(
    text: String,
    onSelected: () -> Unit,
    selectedColor: Color = Orange
) {
    val isSelected = remember {
        mutableStateOf(false)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected.value) selectedColor else Orange,
                shape = Shapes().small
            )
            .background(
                color = if (isSelected.value) selectedColor else Transparent,
                shape = Shapes().small
            )
            .clip(shape = Shapes().small)
            .clickable {
                isSelected.value = !isSelected.value
                if(isSelected.value) {
                    onSelected()
                }
            }
            .padding(4.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected.value) White else Unspecified
        )
    }
}
// Chip View

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun TextChipPreview() {
    AppTheme {
        Row() {

            TextChip(
                text = "Motherboard",
                selectedColor = Orange,
                onSelected = {
                    Log.e("Chip", "selected1")
                }
            )

            TextChip(
                text = "Motherboard",
                selectedColor = Orange,
                onSelected = {
                    Log.e("Chip", "selected2")
                }
            )
        }
    }
}