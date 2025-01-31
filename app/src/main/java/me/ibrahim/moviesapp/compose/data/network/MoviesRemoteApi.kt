package me.ibrahim.moviesapp.compose.data.network

import me.ibrahim.moviesapp.compose.data.dto.MoviesResponseDto
import me.ibrahim.moviesapp.compose.domain.DataError
import me.ibrahim.moviesapp.compose.domain.Result

interface MoviesRemoteApi {



    suspend fun fetchNowPlayingMovies(): Result<MoviesResponseDto, DataError.Remote>

}