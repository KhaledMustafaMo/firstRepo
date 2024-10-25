package com.example.shoppinglist.dp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglist.model.ShoppingItem

@Dao
interface ShoppingItemDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun upSert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query ("SELECT * FROM shopping_item_table")
    fun getAllItem() : LiveData<List<ShoppingItem>>
}