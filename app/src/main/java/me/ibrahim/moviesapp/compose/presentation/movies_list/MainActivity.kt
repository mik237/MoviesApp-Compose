package me.ibrahim.moviesapp.compose.presentation.movies_list

import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.presentation.login.LoginScreen

class MainActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        LoginScreen()
    }

}
