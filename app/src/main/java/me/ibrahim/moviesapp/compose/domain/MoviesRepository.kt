package me.ibrahim.moviesapp.compose.domain

interface MoviesRepository {

    suspend fun fetchNowPlayingMovies(): Result<List<Movie>, DataError.Remote>
    suspend fun fetchUpcomingMovies(): Result<List<Movie>, DataError.Remote>
    suspend fun fetchMovieActors(movieId: Int): Result<List<Actor>, DataError.Remote>
}