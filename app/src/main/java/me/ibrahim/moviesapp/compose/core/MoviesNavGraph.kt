package me.ibrahim.moviesapp.compose.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.movies_detail.MovieDetailScreen
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListScreen
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.reflect.typeOf

@Composable
fun MoviesNavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MoviesListRoute) {

        composable<MoviesListRoute> {
            val viewModel: MoviesListViewModel = koinViewModel()
            MoviesListScreen(viewModel = viewModel, onMovieClick = {
                navController.navigate(MovieDetailRoute(movie = it))
            })
        }

        composable<MovieDetailRoute>(
            typeMap = mapOf(
                typeOf<Movie>() to CustomNavType.MovieType
            )
        ) {
            val movie = it.toRoute<MovieDetailRoute>().movie
            MovieDetailScreen(movie = movie)
        }
    }
}