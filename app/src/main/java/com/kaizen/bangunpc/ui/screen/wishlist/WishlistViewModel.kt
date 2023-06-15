package com.kaizen.bangunpc.ui.screen.wishlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.ProductRepositoryImpl
import com.kaizen.bangunpc.ui.common.UiState
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val repository: ProductRepositoryImpl
) : ViewModel() {
    private val _wishlistState: MutableStateFlow<UiState<List<ProductEntity>>> = MutableStateFlow(
        UiState.Loading)
    val wishlistState = _wishlistState.asStateFlow()

    private val _isEmpty = mutableStateOf(false)
    val isEmpty: State<Boolean>
        get() = _isEmpty

    fun getWishlist() {
        viewModelScope.launch {
            repository.getWishlist()
                .catch {
                    _wishlistState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    if (it.isEmpty()) _isEmpty.value  = true
                    _wishlistState.value = UiState.Success(it)
                }
        }
    }
}