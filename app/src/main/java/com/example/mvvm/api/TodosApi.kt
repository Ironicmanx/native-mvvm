package com.example.mvvm.api

import com.example.mvvm.model.Todo
import retrofit2.http.GET

interface TodosApi {
    @GET("todos")  // Endpoint to get the todos
    suspend fun getTodos(): List<Todo> // Function to retrieve a list of Todo items
}
