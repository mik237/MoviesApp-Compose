package me.ibrahim.moviesapp.compose.presentation.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListScreen

class MainActivity : BaseActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun InitView() {
        Scaffold {
            MainScreen(modifier = Modifier)
        }
    }
}


@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    MoviesListScreen(modifier = modifier)
}

