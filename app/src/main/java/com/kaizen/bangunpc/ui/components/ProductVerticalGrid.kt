package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.data.Product
import com.kaizen.bangunpc.data.dummyProducts
import com.kaizen.bangunpc.ui.theme.AppTheme

@Composable
fun ProductVerticalGrid(
    listProduct: List<Product>,
    modifier: Modifier = Modifier,
    navigateToDetailProduct: (Long) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(listProduct, key = { it.productId }) { product ->
            ProductItem(product,
                modifier = Modifier.clickable {
                    navigateToDetailProduct(product.productId)
                })
        }
    }
}

@Preview
@Composable
fun ProductVerticalGridPreview() {
    AppTheme {
        Scaffold {innerPadding ->
            ProductVerticalGrid(dummyProducts, modifier = Modifier.padding(innerPadding))
        }
    }
}