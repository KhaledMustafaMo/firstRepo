package com.example.shoppinglist.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.databinding.ActivityMainBinding
import com.example.shoppinglist.dp.ShoppingItemDatabase
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.repository.ShoppingItemRepository
import com.example.shoppinglist.ui.utilties.ShoppingItemAddapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val database = ShoppingItemDatabase(this)
        val repository = ShoppingItemRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAddapter(listOf(),viewModel)
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.adapter = adapter

        viewModel.getAllItem().observe(this, Observer {
            adapter.item = it
            adapter.notifyDataSetChanged()
        })

        binding.floatingBtn.setOnClickListener {
            DialogActivity(this,object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }

            }).show()
        }
    }

}