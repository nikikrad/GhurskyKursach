package com.example.ghurskykursach.presentation.movie.response

data class MoviesFirebase(
    val id: String,
    val name: String,
    val poster: String,
    val backdrop: String?
): java.io.Serializable