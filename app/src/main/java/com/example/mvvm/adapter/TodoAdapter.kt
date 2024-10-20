package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.model.Todo

class TodoAdapter(private val todoList: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    // ViewHolder class to hold each item's view
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.todo_title) // Initialize TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false) // Inflate item layout
        return TodoViewHolder(view) // Return the ViewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position] // Get the current todo item
        holder.titleTextView.text = todo.title // Set the title in TextView
    }

    override fun getItemCount(): Int = todoList.size // Return the total item count
}
