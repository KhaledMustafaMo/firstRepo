package com.example.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.databinding.ActivityDialogBinding
import com.example.shoppinglist.model.ShoppingItem

class DialogActivity(context: Context,var addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    private lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.cancelText.setOnClickListener {
            cancel()
        }
        binding.addText.setOnClickListener {
            val itemName : String = binding.itemNameEditText.text.toString()
            val itemAmount : Int = binding.itemAmountEditText.text.toString().toInt()
            if(binding.itemNameEditText.text.toString() ==""||binding.itemAmountEditText.text.toString() == ""){
                Toast.makeText(context,"Please insert missing field",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
                val item = ShoppingItem(itemName,itemAmount)
                addDialogListener.onAddButtonClicked(item)
                dismiss()
        }
    }
}