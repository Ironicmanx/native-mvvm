package com.example.mvvm.userinterface

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.viewmodel.TodoViewModel
import com.example.mvvm.adapter.TodoAdapter

class TodoActivity : AppCompatActivity() {
    private val todoViewModel: TodoViewModel by viewModels() // Get the ViewModel
    private lateinit var recyclerView: RecyclerView // Declare RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo) // Set the layout

        recyclerView = findViewById(R.id.recycler_view) // Initialize RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this) // Set layout manager

        // Observe the todos LiveData from ViewModel
        todoViewModel.todos.observe(this, { todos ->
            recyclerView.adapter = TodoAdapter(todos) // Set the adapter with the todo list
        })
    }
}
