package com.example.ghurskykursach.presentation.movie.comments_model

data class Comments(
    val comment_id: String,
    val movie_id : String,
    val user_name: String,
    val comment: String
)
