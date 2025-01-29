package me.ibrahim.moviesapp.compose

import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.login.LoginScreen

class MainActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        LoginScreen()
    }

}
