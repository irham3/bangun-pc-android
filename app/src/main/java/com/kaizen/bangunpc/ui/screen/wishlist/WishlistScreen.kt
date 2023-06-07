package com.kaizen.bangunpc.ui.screen.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.source.UiState
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.components.WishlistItem

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
                    Column {
                        for (i in 1..5) {
                            WishlistItem(
                                image = "https://onawoodgnwkncueeyusr.supabase.co/storage/v1/object/public/component-images/motherboards/MSI%20B450%20A%20Pro%20MAX.png?t=2023-05-07T15%3A30%3A29.959Z",
                                name = "PC RAKITAN GAMING | INTEL CORE i5 | RX 6600 | SSD 256GB",
                                price = 1295000,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}