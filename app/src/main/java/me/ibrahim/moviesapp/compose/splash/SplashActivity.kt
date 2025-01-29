package me.ibrahim.moviesapp.compose.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.login.LoginActivity
import me.ibrahim.moviesapp.compose.ui.theme.MoviesAppCompTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        SplashScreen() {
            val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}