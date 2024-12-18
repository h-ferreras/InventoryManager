package com.example.inventorymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.ui.ProductListScreen
import com.example.inventorymanager.viewmodel.ProductViewModel
import com.example.inventorymanager.ui.theme.InventoryManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryManagerTheme {
                val viewModel: ProductViewModel = hiltViewModel()
                ProductListScreen(viewModel = viewModel)
            }
        }
    }
}
