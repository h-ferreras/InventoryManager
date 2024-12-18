package com.example.inventorymanager.repository

import com.example.inventorymanager.data.Product
import com.example.inventorymanager.data.ProductDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDao: ProductDao) {

    // Obtener todos los productos
    val allProducts: Flow<List<Product>> = productDao.getAllProducts()

    // Insertar un producto
    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    // Eliminar un producto
    suspend fun delete(product: Product) {
        productDao.delete(product)
    }
}
