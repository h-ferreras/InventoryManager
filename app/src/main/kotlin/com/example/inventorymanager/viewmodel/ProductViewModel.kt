package com.example.inventorymanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventorymanager.data.Product
import com.example.inventorymanager.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

   
    val allProducts: StateFlow<List<Product>> = repository.allProducts
        .stateIn(viewModelScope, kotlinx.coroutines.flow.SharingStarted.Lazily, emptyList())

  
    fun addProduct(product: Product) = viewModelScope.launch {
        repository.insert(product)
    }


    fun deleteProduct(product: Product) = viewModelScope.launch {
        repository.delete(product)
    }
}
