package com.example.shoppinglist.ui

import com.example.shoppinglist.model.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)
}