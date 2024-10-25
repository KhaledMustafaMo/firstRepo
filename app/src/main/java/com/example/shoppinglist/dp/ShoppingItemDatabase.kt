package com.example.shoppinglist.dp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.model.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingItemDatabase : RoomDatabase(){
    abstract fun shoppingItemDao() : ShoppingItemDao

    companion object{
        @Volatile
        private var instance : ShoppingItemDatabase? = null

        val LOCK = Any()
        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: createDatabase(context).also {
                instance = it
            }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingItemDatabase::class.java,
                "shoppingDB.db"
            ).build()
    }
}