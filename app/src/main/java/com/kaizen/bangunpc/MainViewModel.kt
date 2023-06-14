package com.kaizen.bangunpc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaizen.bangunpc.data.source.repository.impl.ProductRepositoryImpl
import com.kaizen.bangunpc.data.source.repository.impl.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepositoryImpl: ProductRepositoryImpl,
    private val userRepositoryImpl: UserRepositoryImpl
    ) : ViewModel() {

    fun provideProductsData() {
        viewModelScope.launch {
            launch { productRepositoryImpl.getAllAMDPCs().collect{} }
            launch { productRepositoryImpl.getAllIntelPCs().collect{} }
            launch { productRepositoryImpl.getAllCPUs().collect{} }
            launch { productRepositoryImpl.getAllGPUs().collect{} }
            launch { productRepositoryImpl.getAllMemories().collect{} }
            launch { productRepositoryImpl.getAllCasings().collect{} }
            launch { productRepositoryImpl.getAllMotherboards().collect{} }
            launch { productRepositoryImpl.getAllPSUs().collect{} }
            launch { productRepositoryImpl.getAllStorages().collect{} }
        }
    }

    fun getCurrentUserSession() =
        userRepositoryImpl.getCurrentSession()

}