package com.example.ghurskykursach.domain.response_by_id

data class DocsById(
    val logo: LogoById?,
    val poster: PosterById?,
    val backdrop: BackdropById?,
    val rating: RatingById?,
    val votes: VotesById?,
    val videos: VideosById?,
    val budget: BudgetById?,
    val fees: FeesById?,
    val premiere: PremiereById?,
    val id: Int?,
    val name: String?,
    val description: String?,
    val genres: List<GenresById>?,
    val persons: List<PersonsById>?,
    val year: Int?,
    val alternativeName: String?,
    val movieLength: String?,
    val shortDescription: String?
)
