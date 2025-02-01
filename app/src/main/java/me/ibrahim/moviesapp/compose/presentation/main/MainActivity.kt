package me.ibrahim.moviesapp.compose.presentation.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.presentation.movies_detail.MovieDetailActivity
import me.ibrahim.moviesapp.compose.presentation.movies_list.MoviesListScreen

class MainActivity : BaseActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun InitView() {
        Scaffold {
            MainScreen(modifier = Modifier) {
                val detailIntent = Intent(this@MainActivity, MovieDetailActivity::class.java)
                startActivity(detailIntent)
            }
        }
    }
}


@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    MoviesListScreen(modifier = modifier, onClick = onClick)
}

