package com.kaizen.bangunpc.ui.screen.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.common.UiState
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.components.layouts.ProductVerticalList

@Composable
fun WishlistScreen(
    wishlistViewModel: WishlistViewModel = hiltViewModel(),
    navigateToDetailProduct: (Int) -> Unit
) {
    val wishlist by wishlistViewModel.wishlistState.collectAsState(initial = UiState.Loading)
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        CustomTopBar(
            content = { ScreenTitleText(title = stringResource(R.string.wishlist)) }
        )
        wishlist.let { uiState ->
            when(uiState) {
                UiState.Loading -> {wishlistViewModel.getWishlist()}
                is UiState.Error -> {}
                is UiState.Success -> {
                    ProductVerticalList(
                        listProduct = uiState.data,
                        navigateToDetailProduct = navigateToDetailProduct
                    )
                }
            }
        }
    }
}