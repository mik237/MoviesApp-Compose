package me.ibrahim.moviesapp.compose.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.ibrahim.moviesapp.compose.BuildConfig
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListScreen

class MainActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        MainScreen()
    }

}


@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val movies = (1..15).map {
        Movie(
            id = it,
            title = "Sonic the Hedgehog 3",
            releaseDate = "Dec 19, 2024",
            posterPath = "${BuildConfig.POSTER_IMAGES_BASEURL}/d8Ryb8AunYAuycVKDp5HpdWPKgC.jpg",
            backdropPath = "${BuildConfig.BACKDROP_IMAGES_BASEURL}/zOpe0eHsq0A2NvNyBbtT6sj53qV.jpg"
        )
    }
    MoviesListScreen(
        movies = movies
    )
}


//{
//    "adult": false,
//    "backdrop_path": "/zOpe0eHsq0A2NvNyBbtT6sj53qV.jpg",
//    "genre_ids": [
//    28,
//    878,
//    35,
//    10751
//    ],
//    "id": 939243,
//    "original_language": "en",
//    "original_title": "Sonic the Hedgehog 3",
//    "overview": "Sonic, Knuckles, and Tails reunite against a powerful new adversary, Shadow, a mysterious villain with powers unlike anything they have faced before. With their abilities outmatched in every way, Team Sonic must seek out an unlikely alliance in hopes of stopping Shadow and protecting the planet.",
//    "popularity": 4739.045,
//    "poster_path": "/d8Ryb8AunYAuycVKDp5HpdWPKgC.jpg",
//    "release_date": "2024-12-19",
//    "title": "Sonic the Hedgehog 3",
//    "video": false,
//    "vote_average": 7.867,
//    "vote_count": 1179
//}
