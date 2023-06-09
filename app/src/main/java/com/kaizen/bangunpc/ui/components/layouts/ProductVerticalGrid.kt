package com.kaizen.bangunpc.ui.components.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.ui.components.GridItem

@Composable
fun ProductVerticalGrid(
    modifier: Modifier = Modifier,
    state: LazyGridState = rememberLazyGridState(),
    listProduct: List<ProductEntity>,
    navigateToDetailProduct: (Int) -> Unit = {}
) {
    LazyVerticalGrid(
        modifier = modifier,
        state = state,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(listProduct, key = { it.id }) { product ->
            GridItem(
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