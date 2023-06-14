package com.kaizen.bangunpc.ui.screen.catalog

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.ProductRepositoryImpl
import com.kaizen.bangunpc.ui.common.UiState
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val repository: ProductRepositoryImpl
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

    fun getProductsByCategory(chipList: String) {
        when(chipList) {
            "Lihat Semua" -> getAllProducts()
            "PC Intel" -> setProductsDataByCategory(repository.getAllIntelPCs())
            "PC AMD" -> setProductsDataByCategory(repository.getAllAMDPCs())
            "Motherboard" -> setProductsDataByCategory(repository.getAllMotherboards())
            "Storage" -> setProductsDataByCategory(repository.getAllStorages())
            "CPU" -> setProductsDataByCategory(repository.getAllCPUs())
            "GPU" -> setProductsDataByCategory(repository.getAllGPUs())
            "Casing" -> setProductsDataByCategory(repository.getAllCasings())
            "Memory" -> setProductsDataByCategory(repository.getAllMemories())
            "Power Supply" -> setProductsDataByCategory(repository.getAllPSUs())
        }
    }

    private fun setProductsDataByCategory(dataFlowState: Flow<UiState<List<ProductEntity>>>) {
        viewModelScope.launch {
            dataFlowState
                .catch {
                    _products.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _products.value = it
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
                        _products.value = UiState.Success(it)
                    }
            }
        } else
            getAllProducts()
    }
}