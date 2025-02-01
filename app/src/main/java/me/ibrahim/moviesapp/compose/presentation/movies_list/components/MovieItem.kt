package me.ibrahim.moviesapp.compose.presentation.movies_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import me.ibrahim.moviesapp.compose.R
import me.ibrahim.moviesapp.compose.domain.Movie


@Preview
@Composable
fun MovieItem(
    movie: Movie = Movie(id = 1)
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(id = R.color.black4),
            contentColor = Color.White
        ),
        modifier = Modifier
            .width(175.dp)
    ) {

        Column() {

            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.title,
                modifier = Modifier
                    .width(175.dp)
                    .aspectRatio(ratio = 2 / 3f)
            )

            Text(
                text = movie.title ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(5.dp)
            )

            Text(
                text = movie.releaseDate ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
            )
        }
    }
}