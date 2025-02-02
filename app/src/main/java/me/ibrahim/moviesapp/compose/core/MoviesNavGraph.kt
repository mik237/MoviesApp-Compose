package me.ibrahim.moviesapp.compose.core

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.json.Json
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.movies_detail.MovieDetailActivity
import me.ibrahim.moviesapp.compose.presentation.movies_detail.MovieDetailScreen
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListScreen
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.reflect.typeOf

@Composable
fun MoviesNavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = MoviesListRoute,
        modifier = modifier
    ) {

        composable<MoviesListRoute> {
            val viewModel: MoviesListViewModel = koinViewModel()
            MoviesListScreen(viewModel = viewModel, onMovieClick = {
//                navController.navigate(MovieDetailRoute(movie = it))
                val detailIntent = Intent(context, MovieDetailActivity::class.java)
                val movie = Json.encodeToString(it)
                detailIntent.putExtra("movie", movie)
                context.startActivity(detailIntent)
            })
        }

        composable<MovieDetailRoute>(
            typeMap = mapOf(
                typeOf<Movie>() to CustomNavType.MovieType
            )
        ) {
            val movie = it.toRoute<MovieDetailRoute>().movie
            MovieDetailScreen(movie = movie, onBack = { navController.navigateUp() })
        }
    }
}