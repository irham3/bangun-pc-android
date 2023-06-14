package com.kaizen.bangunpc.ui.screen.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private  val repository: ProductRepositoryImpl
) : ViewModel(){
    private val _detailState = MutableStateFlow(DetailUiState.Product())
    val detailState = _detailState.asStateFlow()

    private val _isFavorite = mutableStateOf(false)
    val isFavorite: State<Boolean>
        get() = _isFavorite


    fun getDetailProduct(productId: Int) {
        viewModelScope.launch {
            repository.getProductById(productId)
                .catch {
                    _detailState.value = DetailUiState.Product(error = it.message.toString())
                }
                .collect {
                    _detailState.value = DetailUiState.Product(data = it)
                    _isFavorite.value = it.isFavorite
                }
        }
    }


    fun setFavorite() {
        _isFavorite.value = !_isFavorite.value
        viewModelScope.launch {
            detailState.collect{
                repository.setFavorite(it.data, _isFavorite.value)
            }
        }
    }
}