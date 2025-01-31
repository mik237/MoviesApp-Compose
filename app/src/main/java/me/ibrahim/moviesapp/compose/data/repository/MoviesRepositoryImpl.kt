package me.ibrahim.moviesapp.compose.data.repository

import me.ibrahim.moviesapp.compose.data.mappers.toMovie
import me.ibrahim.moviesapp.compose.data.network.MoviesRemoteApi
import me.ibrahim.moviesapp.compose.domain.DataError
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.domain.MoviesRepository
import me.ibrahim.moviesapp.compose.domain.Result
import me.ibrahim.moviesapp.compose.domain.map

class MoviesRepositoryImpl(private val moviesRemoteApi: MoviesRemoteApi) : MoviesRepository {

    override suspend fun fetchNowPlayingMovies(): Result<List<Movie>, DataError.Remote> {
        return moviesRemoteApi.fetchNowPlayingMovies()
            .map { response ->
                response.results?.let { moviesDto ->
                    moviesDto.map { movieDto ->
                        movieDto.toMovie()
                    }
                } ?: emptyList()
            }
    }
}