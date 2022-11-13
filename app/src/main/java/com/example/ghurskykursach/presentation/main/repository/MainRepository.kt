package com.example.ghurskykursach.presentation.main.repository

import com.example.ghurskykursach.domain.ApiService
import com.example.ghurskykursach.domain.response.Films

class MainRepository(private val retrofit: ApiService){

    suspend fun getMovie(): Films? {
        return retrofit.getMovie().body()
    }
}