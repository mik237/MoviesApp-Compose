package me.ibrahim.moviesapp.compose.presentation.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import me.ibrahim.moviesapp.compose.R

@Composable
fun FavoriteMoviesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackBackground))
    ) {
        Image(painter = painterResource(id = R.drawable.bg1), contentDescription = null)

        Text(
            text = "Favorite Movies",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}