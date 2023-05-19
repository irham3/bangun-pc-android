package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.data.Product

@Composable
fun ProductRow(
    listProduct: List<Product>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(listProduct, key = { it.title }) { product ->
            ProductItem(product)
        }
    }
}