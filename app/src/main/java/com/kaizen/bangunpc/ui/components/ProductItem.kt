package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.Product
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(120.dp)
            .clickable {  },
        border = BorderStroke(1.dp, Orange),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            Image(
                painter = painterResource(product.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    color = Color.Black,
                    text = product.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    color = Color.Black,
                    text = product.price,
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
        ProductItem(
            product = Product(R.drawable.component1, "PC RAKITAN GAMING | INTEL CORE i5 | RX 6600 | SSD 256GB", "Rp 11.641.000"),
            modifier = Modifier.padding(8.dp)
        )
    }
}