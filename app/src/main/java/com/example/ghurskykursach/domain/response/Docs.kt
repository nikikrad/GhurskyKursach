package com.example.ghurskykursach.domain.response

data class Docs(
    val poster: Poster,
    val rating: Rating,
    val votes: Votes,
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val alternativeName: String,
    val movieLength: String,
    val shortDescription: String
)
