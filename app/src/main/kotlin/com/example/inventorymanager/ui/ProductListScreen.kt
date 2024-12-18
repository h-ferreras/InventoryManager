package com.example.inventorymanager.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.data.Product
import com.example.inventorymanager.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel) {
    val products by viewModel.allProducts.collectAsState(initial = emptyList())

    // Variables para capturar el input del usuario
    var productName by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Título
        Text("Gestión de Inventarios", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        // Campos de entrada
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text("Cantidad") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para agregar un producto
        Button(
            onClick = {
                if (productName.isNotBlank() && productQuantity.isNotBlank() && productPrice.isNotBlank()) {
                    viewModel.addProduct(
                        Product(
                            name = productName,
                            quantity = productQuantity.toInt(),
                            price = productPrice.toDouble()
                        )
                    )
                    // Limpiar campos después de agregar el producto
                    productName = ""
                    productQuantity = ""
                    productPrice = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Producto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de productos
        LazyColumn {
            items(products) { product ->
                ProductItem(product = product, onDelete = { viewModel.deleteProduct(product) })
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(product.name, style = MaterialTheme.typography.bodyLarge)
                Text("Cantidad: ${product.quantity}", style = MaterialTheme.typography.bodyMedium)
                Text("Precio: \$${product.price}", style = MaterialTheme.typography.bodyMedium)
            }
            Button(onClick = onDelete) {
                Text("Eliminar")
            }
        }
    }
}
