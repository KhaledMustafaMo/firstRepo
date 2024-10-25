package com.example.shoppinglist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity ("shopping_item_table")
data class ShoppingItem(
    @ColumnInfo("shopping_items")
    val item : String,
    @ColumnInfo("item_amount")
     var amount : Int) {

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
 }