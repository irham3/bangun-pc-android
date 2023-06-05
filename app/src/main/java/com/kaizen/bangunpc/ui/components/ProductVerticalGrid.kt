package com.kaizen.bangunpc.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity

@Composable
fun ProductVerticalGrid(
    listProduct: List<ProductEntity>,
    modifier: Modifier = Modifier,
    navigateToDetailProduct: (Int) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(listProduct, key = { it.id }) { product ->
            ProductItem(
                image = product.image,
                name = product.name,
                price = product.price,
                modifier = Modifier.clickable {
                    navigateToDetailProduct(product.id)
                })
        }
    }
}

//@Preview
//@Composable
//fun ProductVerticalGridPreview() {
//    AppTheme {
//        Scaffold {innerPadding ->
//            ProductVerticalGrid(dummyProducts, modifier = Modifier.padding(innerPadding))
//        }
//    }
//}