package com.kaizen.bangunpc.ui.screen.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.source.UiState
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ScreenTitleText

@Composable
fun WishlistScreen(
    wishlistViewModel: WishlistViewModel = hiltViewModel()
) {
    val wishlist by wishlistViewModel.wishlistState.collectAsState(initial = UiState.Loading)
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        CustomTopBar(
            content = { ScreenTitleText(title = stringResource(R.string.wishlist)) }
        )
        wishlist.let { uiState ->
            when(uiState) {
                UiState.Loading -> {wishlistViewModel.getWishlist()}
                is UiState.Error -> {}
                is UiState.Success -> {
                    Text(text = uiState.data.toString())
                }
            }
        }
    }

}