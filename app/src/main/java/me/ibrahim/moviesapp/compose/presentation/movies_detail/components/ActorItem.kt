package me.ibrahim.moviesapp.compose.presentation.movies_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import me.ibrahim.moviesapp.compose.BuildConfig
import me.ibrahim.moviesapp.compose.domain.Actor

@Composable
fun ActorItem(
    modifier: Modifier = Modifier,
    actor: Actor
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = actor.name ?: "",
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        )
        AsyncImage(
            model = "${BuildConfig.POSTER_IMAGES_BASEURL}${actor.profilePath}",
            contentDescription = actor.name,
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 10.dp)
                .clip(CircleShape)
                .border(
                    width = 0.5.dp, color = Color.White,
                    shape = CircleShape
                )
        )
    }
}