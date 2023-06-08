package com.kaizen.bangunpc.ui.components.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.ui.components.ListItem

@Composable
fun ProductVerticalList(
    listProduct: List<ProductEntity>,
    modifier: Modifier = Modifier,
    navigateToDetailProduct: (Int) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        items(listProduct, key = { it.id }) { product ->
            ListItem(
                image = product.image,
                name = product.name,
                price = product.price,
                modifier = modifier
                    .clickable {
                    navigateToDetailProduct(product.id)
                })
        }
    }
}