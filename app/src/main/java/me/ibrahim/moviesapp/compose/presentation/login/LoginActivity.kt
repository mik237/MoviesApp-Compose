package me.ibrahim.moviesapp.compose.presentation.login

import androidx.compose.runtime.Composable
import me.ibrahim.moviesapp.compose.core.BaseActivity

class LoginActivity : BaseActivity() {
    @Composable
    override fun InitView() {
        LoginScreen()
    }
}