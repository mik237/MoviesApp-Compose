package me.ibrahim.moviesapp.compose.presentation.movies_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import me.ibrahim.moviesapp.compose.domain.Movie


@Preview
@Composable
fun MovieItem(
    movie: Movie = Movie()
) {
    Column {
        ElevatedCard(
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {

            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.title,
                modifier = Modifier
                    .width(175.dp)
                    .aspectRatio(ratio = 2 / 3f)
                    .clip(RoundedCornerShape(10.dp)),
            )
        }

        Text(
            text = movie.title ?: "",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = movie.releaseDate ?: "",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.LightGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin
            )
        )
    }
}