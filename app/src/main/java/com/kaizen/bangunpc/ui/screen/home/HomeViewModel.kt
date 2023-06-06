package com.kaizen.bangunpc.ui.screen.home

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
class HomeViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel() {
    private val _componentState: MutableStateFlow<UiState<List<ProductEntity>>> = MutableStateFlow(UiState.Loading)
    val componentState = _componentState.asStateFlow()

    private val _intelPCState: MutableStateFlow<UiState<List<ProductEntity>>> = MutableStateFlow(UiState.Loading)
    val intelPCState = _intelPCState.asStateFlow()

    private val _amdPCState: MutableStateFlow<UiState<List<ProductEntity>>> = MutableStateFlow(UiState.Loading)
    val amdPCState = _amdPCState.asStateFlow()

    fun getAllComponents() {
        viewModelScope.launch {
            repository.getAllCasings()
                .catch {
                    _componentState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _componentState.value = it
                }
        }
    }

    fun getAllIntelPCs() {
        viewModelScope.launch {
            repository.getAllIntelPCs()
                .catch {
                    _intelPCState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _intelPCState.value = it
                }
        }
    }

    fun getAllAMDPCs() {
        viewModelScope.launch {
            repository.getAllAMDPCs()
                .catch {
                    _amdPCState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _amdPCState.value = it
                }
        }
    }

}