package com.example.ghurskykursach.presentation.search.repository

import com.example.ghurskykursach.domain.ApiService
import com.example.ghurskykursach.domain.response.Films
import com.example.ghurskykursach.domain.response_by_id.DocsById

class SearchRepository(private val retrofit: ApiService)  {

    suspend fun getMovieByName(name: String): Films? {
        return retrofit.getMovieByName(name).body()
    }
}