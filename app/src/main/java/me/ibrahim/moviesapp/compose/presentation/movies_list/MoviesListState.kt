package me.ibrahim.moviesapp.compose.presentation.movies_list

import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.main.UiText

data class MoviesListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val errorMsg: UiText? = null
)
