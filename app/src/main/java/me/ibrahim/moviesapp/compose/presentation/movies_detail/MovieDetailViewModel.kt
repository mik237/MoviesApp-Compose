package me.ibrahim.moviesapp.compose.presentation.movies_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
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

class MovieDetailViewModel(
    private val moviesRepository: MoviesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId: Int = 539972

    private val _state = MutableStateFlow(MovieDetailState())
    val state = _state
        .onStart {
            fetchActorsList()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: MovieDetailActions) {
        when (action) {
            MovieDetailActions.GoBack -> {}
            is MovieDetailActions.MarkFavorite -> {}
        }
    }


    private fun fetchActorsList() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            moviesRepository.fetchMovieActors(movieId = movieId)
                .onSuccess { actors ->
                    _state.update {
                        it.copy(actors = actors, isLoading = false)
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(isLoading = false, errorMessage = error.toUiText())
                    }
                }
        }
    }
}