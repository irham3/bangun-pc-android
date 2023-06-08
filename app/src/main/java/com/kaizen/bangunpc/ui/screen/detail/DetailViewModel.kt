package com.kaizen.bangunpc.ui.screen.detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.ProductRepository
import com.kaizen.bangunpc.data.source.UiState
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private  val repository: ProductRepository
) : ViewModel(){
    private val _detailState: MutableStateFlow<UiState<ProductEntity>> = MutableStateFlow(UiState.Loading)
    val detailState = _detailState.asStateFlow()

    private val _isFavorite = mutableStateOf(false)
    val isFavorite: State<Boolean>
        get() = _isFavorite

    fun getDetailProduct(productId: Int) {
        viewModelScope.launch {
            repository.getProductById(productId)
                .catch {
                    _detailState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _detailState.value = UiState.Success(it)
                    _isFavorite.value = it.isFavorite
                }
        }
    }

    fun setFavorite() {
        Log.e("favorite", isFavorite.value.toString())
        _isFavorite.value = !_isFavorite.value
        detailState.value.let {
            when(it) {
                is UiState.Error -> {}
                UiState.Loading -> {}
                is UiState.Success -> {
                    viewModelScope.launch {
                        repository.setFavorite(it.data, _isFavorite.value)
                    }
                }
            }
        }
    }
}