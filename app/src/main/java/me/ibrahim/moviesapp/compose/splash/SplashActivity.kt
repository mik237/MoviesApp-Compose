package me.ibrahim.moviesapp.compose.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.ibrahim.moviesapp.compose.login.LoginActivity
import me.ibrahim.moviesapp.compose.ui.theme.MoviesAppCompTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesAppCompTheme {

                SplashScreen() {
                    val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(loginIntent)
                }

            }
        }
    }
}