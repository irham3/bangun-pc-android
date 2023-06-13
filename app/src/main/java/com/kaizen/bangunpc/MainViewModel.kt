package com.kaizen.bangunpc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.ProductRepository
import com.kaizen.bangunpc.data.source.repository.impl.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
    ) : ViewModel() {

    fun provideProductsData() {
        viewModelScope.launch {
            launch { productRepository.getAllAMDPCs().collect{} }
            launch { productRepository.getAllIntelPCs().collect{} }
            launch { productRepository.getAllCPUs().collect{} }
            launch { productRepository.getAllGPUs().collect{} }
            launch { productRepository.getAllMemories().collect{} }
            launch { productRepository.getAllCasings().collect{} }
            launch { productRepository.getAllMotherboards().collect{} }
            launch { productRepository.getAllPSUs().collect{} }
            launch { productRepository.getAllStorages().collect{} }
        }
    }

    fun getCurrentUserSession() =
        userRepository.getCurrentSession()

}