package com.kaizen.bangunpc.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.ComponentRepository
import com.kaizen.bangunpc.data.source.UiState
import com.kaizen.bangunpc.data.source.local.entity.impl.ComponentEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ComponentRepository
): ViewModel() {
    private val _componentState: MutableStateFlow<UiState<List<ComponentEntity>>> = MutableStateFlow(UiState.Loading)
    val componentState = _componentState.asStateFlow()

    fun getAllComponents() {
        // Get all components
        viewModelScope.launch {
            repository.getAllComponents()
                .catch {
                    _componentState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _componentState.value = it
                }
        }
    }

}