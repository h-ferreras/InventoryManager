package com.example.inventorymanager.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
