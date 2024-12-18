package com.example.inventorymanager.di

import android.content.Context
import androidx.room.Room
import com.example.inventorymanager.data.InventoryDatabase
import com.example.inventorymanager.data.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext context: Context): InventoryDatabase {
        return Room.databaseBuilder(
            context,
            InventoryDatabase::class.java,
            "inventory_database"
        ).build()
    }

    @Provides
    fun provideProductDao(database: InventoryDatabase): ProductDao {
        return database.productDao()
    }
}
