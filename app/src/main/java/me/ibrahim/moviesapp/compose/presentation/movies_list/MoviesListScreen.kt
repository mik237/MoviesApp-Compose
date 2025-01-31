package me.ibrahim.moviesapp.compose.presentation.movies_list

import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.movies_list.components.MoviesList

@Composable
fun MoviesListScreen(movies: List<Movie>) {
    MoviesList(movies = movies)
}