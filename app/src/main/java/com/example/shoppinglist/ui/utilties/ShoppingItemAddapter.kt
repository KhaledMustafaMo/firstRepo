package com.example.shoppinglist.ui.utilties

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ShoppingListBinding
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.ui.ShoppingViewModel

class ShoppingItemAddapter(var item : List<ShoppingItem>,val viewModel: ShoppingViewModel) : RecyclerView.Adapter<ShoppingItemAddapter.ShoppingHolder>(){
    inner class ShoppingHolder(val binding: ShoppingListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingHolder {
        return ShoppingHolder(ShoppingListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return item.size
    }


    override fun onBindViewHolder(holder: ShoppingHolder, position: Int) {
        val currentShoppingItem = item[position]
        holder.binding.itemName.text = currentShoppingItem.item
        holder.binding.itemAmount.text = currentShoppingItem.amount.toString()

        holder.binding.deleteImage.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.binding.minusImage.setOnClickListener {
            if(currentShoppingItem.amount>0) {
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }
        }
        holder.binding.plusImage.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
    }
}
