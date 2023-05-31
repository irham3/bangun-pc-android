package com.kaizen.bangunpc.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.ComponentRepository
import com.kaizen.bangunpc.data.source.UiState
import com.kaizen.bangunpc.data.source.local.entity.ComponentEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ComponentRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<ComponentEntity>>> = MutableStateFlow(UiState.Loading())
    val uiState: StateFlow<UiState<List<ComponentEntity>>>
        get() = _uiState

    fun getAllComponents() {
        viewModelScope.launch {
            repository.getAllComponents()
                .catch {
                    _uiState.value
                }
                .collect {

                }
        }
    }

}