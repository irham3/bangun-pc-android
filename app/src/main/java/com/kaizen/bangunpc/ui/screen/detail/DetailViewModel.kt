package com.kaizen.bangunpc.ui.screen.detail

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

    fun getDetailProduct(productId: Int) {
        viewModelScope.launch {
            repository.getProductById(productId)
                .catch {
                    _detailState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _detailState.value = UiState.Success(it)
                }
        }
    }
}