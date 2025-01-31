package me.ibrahim.moviesapp.compose.di

import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val coreModule = module {
    viewModelOf(::MoviesListViewModel)
}