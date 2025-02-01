package me.ibrahim.moviesapp.compose.presentation.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.core.MoviesNavGraph

class MainActivity : BaseActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun InitView() {
        Scaffold {
            MoviesNavGraph()
        }
    }
}


