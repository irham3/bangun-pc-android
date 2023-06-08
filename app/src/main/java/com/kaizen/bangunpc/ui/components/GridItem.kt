package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kaizen.bangunpc.utils.toRupiahFormat

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    price: Int,
) {
    Card(
        modifier = modifier
            .shadow(8.dp)
            .width(120.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            AsyncImage(
                model = image,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    color = Color.Black,
                    text = name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    color = Color.Black,
                    text = price.toRupiahFormat(),
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProductItemPreview() {
    MaterialTheme {
        GridItem(
            image = "https://onawoodgnwkncueeyusr.supabase.co/storage/v1/object/public/component-images/motherboards/MSI%20B450%20A%20Pro%20MAX.png?t=2023-05-07T15%3A30%3A29.959Z",
            name = "PC RAKITAN GAMING | INTEL CORE i5 | RX 6600 | SSD 256GB",
            price = 1295000,
            modifier = Modifier.padding(8.dp)
        )
    }
}