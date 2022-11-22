package com.example.ghurskykursach.domain.response

import com.example.ghurskykursach.domain.response_by_id.VideosById

data class Docs(
    val poster: Poster,
    val rating: Rating,
    val votes: Votes,
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val video: VideosById?,
    val alternativeName: String,
    val movieLength: String,
    val shortDescription: String
)
