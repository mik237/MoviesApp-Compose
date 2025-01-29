package me.ibrahim.moviesapp.compose.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.ibrahim.moviesapp.compose.ui.theme.MoviesAppCompTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesAppCompTheme {
                LoginScreen()
            }
        }
    }
}