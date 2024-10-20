package com.example.mvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/" // Base URL of the API

    // Create a Retrofit instance and implement the TodosApi interface
    val instance: TodosApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson for JSON conversion
            .build()
        retrofit.create(TodosApi::class.java) // Create the API service
    }
}
