package com.kaizen.bangunpc.ui.screen.catalog

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.ProductRepository
import com.kaizen.bangunpc.ui.common.UiState
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
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

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

    fun search(newQuery: String) {
        _query.value = newQuery
        if(newQuery.isNotEmpty()) {
            viewModelScope.launch {
                repository.getProductsByName(newQuery)
                    .catch {
                        _products.value = UiState.Error(it.message.toString())
                    }
                    .collect {
                        Log.e("products", newQuery)
                        Log.e("products", it.toString())
                        _products.value = UiState.Success(it)
                    }
            }
        } else
            getAllProducts()
    }
}