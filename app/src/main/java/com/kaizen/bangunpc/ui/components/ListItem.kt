package com.kaizen.bangunpc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange
import com.kaizen.bangunpc.utils.toRupiahFormat

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    price: Int,
) {
    Card(
        modifier = modifier
            .padding(vertical = 2.dp, horizontal = 4.dp)
            .shadow(8.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                contentDescription = name,
                model = image,
                modifier = modifier.size(80.dp)
            )
            Spacer(modifier = modifier.width(8.dp))
            Column(modifier = modifier.weight(1f)) {
                Text(
                    color = Color.Black,
                    text = name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    color = Orange,
                    text = price.toRupiahFormat(),
                    style = MaterialTheme.typography.body1.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
private fun WishlistItemPreview() {
    AppTheme {
        Column {
            for (i in 1..5) {
                ListItem(
                    image = "https://onawoodgnwkncueeyusr.supabase.co/storage/v1/object/public/component-images/motherboards/MSI%20B450%20A%20Pro%20MAX.png?t=2023-05-07T15%3A30%3A29.959Z",
                    name = "PC RAKITAN GAMING | INTEL CORE i5 | RX 6600 | SSD 256GB",
                    price = 1295000,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}