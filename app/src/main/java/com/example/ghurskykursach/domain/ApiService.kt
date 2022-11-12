package com.example.ghurskykursach.domain

import com.example.ghurskykursach.domain.response.Films
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie?isStrict=false&field=name")
    fun getMovie(
        @Query("token") token: String,
        @Query("search") search: String,
    ): Response<List<Films>>
}