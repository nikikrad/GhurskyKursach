package com.example.ghurskykursach.domain

import com.example.ghurskykursach.domain.response.Films
import com.example.ghurskykursach.domain.response_by_id.DocsById
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie?isStrict=false&field=name&token=HB6B6RM-2VC45QY-KY7D7BE-GRVSZX4")
    suspend fun getMovieByName(
        @Query("search") search: String
    ): Response<Films>

    @GET("movie?token=HB6B6RM-2VC45QY-KY7D7BE-GRVSZX4&field=id")
    suspend fun getMovieById(
        @Query("search") id: Int
    ): Response<DocsById>

    @GET("movie?token=HB6B6RM-2VC45QY-KY7D7BE-GRVSZX4&field=year&search=2021&page=25&limit=30")
    suspend fun getMovie():Response<Films>
}