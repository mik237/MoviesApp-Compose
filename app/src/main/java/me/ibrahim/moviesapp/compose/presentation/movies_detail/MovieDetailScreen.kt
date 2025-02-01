package me.ibrahim.moviesapp.compose.presentation.movies_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.ibrahim.moviesapp.compose.BuildConfig
import me.ibrahim.moviesapp.compose.R
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.movies_detail.components.ActorsList
import me.ibrahim.moviesapp.compose.presentation.movies_detail.components.MovieDetailContent
import me.ibrahim.moviesapp.compose.presentation.movies_detail.components.MovieDetailHeader
import me.ibrahim.moviesapp.compose.presentation.movies_detail.components.MovieDetailToolbar
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun MovieDetailScreen(
    movie: Movie = Movie(
        title = "The Gardener",
        id = 539972,
        posterPath = "${BuildConfig.POSTER_IMAGES_BASEURL}/5T9WR7vIOnHm6xhVt5zBuPbBgt1.jpg",
        overview = "Sonic, Knuckles, and Tails reunite against a powerful new adversary, Shadow, a mysterious villain with powers unlike anything they have faced before. With their abilities outmatched in every way, Team Sonic must seek out an unlikely alliance in hopes of stopping Shadow and protecting the planet."
    ),
    viewModel: MovieDetailViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .matchParentSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            MovieDetailHeader(movie = state.movie, modifier = Modifier.aspectRatio(1f))

            MovieDetailContent(state = state, modifier = Modifier.weight(1f))
        }

        Image(painter = painterResource(id = R.drawable.bg1), contentDescription = null)

        MovieDetailToolbar(
            modifier = Modifier
                .align(Alignment.TopCenter),
            movie = state.movie,
            onAction = {}
        )
    }
}