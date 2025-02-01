package me.ibrahim.moviesapp.compose.presentation.movies_detail

import me.ibrahim.moviesapp.compose.domain.Actor
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.main.UiText

data class MovieDetailState(
    val actors: List<Actor>? = null,
    val movie: Movie? = null,
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null
)
