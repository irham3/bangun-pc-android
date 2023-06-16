package com.kaizen.bangunpc.ui.components.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.ui.components.ListItem

@Composable
fun ProductVerticalList(
    listProduct: List<ProductEntity>,
    modifier: Modifier = Modifier,
    navigateToDetailProduct: (Int) -> Unit
) {
    if(listProduct.isEmpty())
        EmptyDataText()
    else {
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
}

@Composable
private fun EmptyDataText() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.empty_list_animation)
        )
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(300.dp),
            iterations = LottieConstants.IterateForever,
            // Lottie and pause/play
            isPlaying = true,
            // Increasing the speed of change Lottie
            speed = 1.5f,
            restartOnPlay = false
        )
        Text(text = "Belum ada wishlist yang ditambahkan")
    }
}