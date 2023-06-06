package com.kaizen.bangunpc.ui.screen.wishlist

import androidx.lifecycle.ViewModel
import com.kaizen.bangunpc.data.source.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

}