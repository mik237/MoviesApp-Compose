package me.ibrahim.moviesapp.compose.data.mappers

import me.ibrahim.moviesapp.compose.BuildConfig
import me.ibrahim.moviesapp.compose.data.dto.MovieDto
import me.ibrahim.moviesapp.compose.domain.Movie

fun MovieDto.toMovie(): Movie {

    return Movie(
        adult = adult,
        backdropPath = "${BuildConfig.BACKDROP_IMAGES_BASEURL}$backdropPath",
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = "${BuildConfig.POSTER_IMAGES_BASEURL}$posterPath",
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}