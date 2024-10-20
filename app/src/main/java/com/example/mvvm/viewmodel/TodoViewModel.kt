package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.mvvm.api.ApiService
import com.example.mvvm.model.Todo


class TodoViewModel : ViewModel() {
    private val _todos = MutableLiveData<List<Todo>>() // Backing property for LiveData
    val todos: LiveData<List<Todo>> get() = _todos // Expose LiveData to observe

    init {
        getTodosList() // Fetch the todos when ViewModel is created
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                _todos.value = ApiService.instance.getTodos() // Fetch and set todos
            } catch (e: Exception) {
                // Handle the exception (for example, log the error)
                e.printStackTrace() // Print stack trace for debugging
            }
        }
    }
}
