package me.ibrahim.moviesapp.compose.presentation.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.ui.theme.MoviesAppCompTheme

class LoginActivity : BaseActivity() {
    @Composable
    override fun InitView() {
        LoginScreen()
    }
}