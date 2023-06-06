package com.kaizen.bangunpc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    fun provideProductsData() {
        viewModelScope.launch {
            launch { repository.getAllAMDPCs().collect{} }
            launch { repository.getAllIntelPCs().collect{} }
            launch { repository.getAllCPUs().collect{} }
            launch { repository.getAllGPUs().collect{} }
            launch { repository.getAllMemories().collect{} }
            launch { repository.getAllCasings().collect{} }
            launch { repository.getAllMotherboards().collect{} }
            launch { repository.getAllPSUs().collect{} }
            launch { repository.getAllStorages().collect{} }
        }
    }

}