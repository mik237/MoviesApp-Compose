package me.ibrahim.moviesapp.compose.presentation.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.ibrahim.moviesapp.compose.domain.MoviesRepository
import me.ibrahim.moviesapp.compose.domain.onError
import me.ibrahim.moviesapp.compose.domain.onSuccess
import me.ibrahim.moviesapp.compose.presentation.main.toUiText

class MoviesListViewModel(private val repository: MoviesRepository) : ViewModel() {

    private var moviesListJob: Job? = null

    private val _state = MutableStateFlow(MoviesListState())
    val state = _state
        .onStart { fetchMovies() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private fun fetchMovies() {

        moviesListJob?.cancel()

        moviesListJob = viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            repository.fetchNowPlayingMovies().onSuccess { movies ->
                _state.update {
                    it.copy(
                        movies = movies, isLoading = false, errorMsg = null
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false, movies = emptyList(), errorMsg = error.toUiText()
                    )
                }
            }
        }
    }
}