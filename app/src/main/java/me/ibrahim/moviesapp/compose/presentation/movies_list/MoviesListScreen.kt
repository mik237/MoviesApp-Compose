package me.ibrahim.moviesapp.compose.presentation.movies_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.ibrahim.moviesapp.compose.R
import me.ibrahim.moviesapp.compose.presentation.movies_list.components.MoviesList
import me.ibrahim.moviesapp.compose.presentation.movies_list.components.TitledMoviesList
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoviesListScreen(
    modifier: Modifier = Modifier,
    viewModel: MoviesListViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blackBackground))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            TitledMoviesList(title = stringResource(id = R.string.now_playing)) {
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else {
                    MoviesList(movies = state.movies)
                }
            }

            TitledMoviesList(title = stringResource(id = R.string.now_playing)) {
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else {
                    MoviesList(movies = state.movies)
                }
            }

        }
        Image(painter = painterResource(id = R.drawable.bg1), contentDescription = null)
    }
}