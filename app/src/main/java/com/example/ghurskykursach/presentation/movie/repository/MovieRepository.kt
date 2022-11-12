package com.example.ghurskykursach.presentation.movie.repository

import com.example.ghurskykursach.domain.ApiService
import com.example.ghurskykursach.domain.response.Films
import com.example.ghurskykursach.domain.response_by_id.DocsById
import com.example.ghurskykursach.domain.response_by_id.FilmsById

class MovieRepository(private val retrofit: ApiService) {

    suspend fun getMovieById( id: Int): DocsById? {
        return retrofit.getMovieById(id).body()
    }

}