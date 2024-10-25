package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.repository.ShoppingItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingItemRepository) : ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllItem() = repository.getAllItem()
}