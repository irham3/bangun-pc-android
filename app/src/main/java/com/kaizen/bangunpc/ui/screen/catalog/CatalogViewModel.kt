package com.kaizen.bangunpc.ui.screen.catalog

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
class CatalogViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel(){
    private val _products: MutableStateFlow<UiState<List<ProductEntity>>> = MutableStateFlow(UiState.Loading)
    val productsState = _products.asStateFlow()

    fun getAllProducts() {
        viewModelScope.launch {
            repository.getAllProducts()
                .catch {
                    _products.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _products.value = UiState.Success(it)
                }
        }
    }
}