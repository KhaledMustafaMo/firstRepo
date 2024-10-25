package com.example.shoppinglist.repository

import com.example.shoppinglist.dp.ShoppingItemDatabase
import com.example.shoppinglist.model.ShoppingItem

class ShoppingItemRepository(private val shoppingItemDB : ShoppingItemDatabase){
    suspend fun upsert(item : ShoppingItem) = shoppingItemDB.shoppingItemDao().upSert(item)
    suspend fun delete(item: ShoppingItem) = shoppingItemDB.shoppingItemDao().delete(item)
    fun getAllItem() = shoppingItemDB.shoppingItemDao().getAllItem()
}