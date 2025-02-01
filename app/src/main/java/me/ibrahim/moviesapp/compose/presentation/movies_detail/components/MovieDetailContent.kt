package me.ibrahim.moviesapp.compose.presentation.movies_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.moviesapp.compose.R
import me.ibrahim.moviesapp.compose.domain.Movie

@Composable
fun MovieDetailContent(
    modifier: Modifier = Modifier,
    movie: Movie
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.black1))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .matchParentSize()
                .padding(16.dp)
        ) {

            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = movie.title ?: "The Gardener",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )

            Row(
                horizontalArrangement = Arrangement.Absolute.spacedBy(10.dp),
            ) {
                TitledIcon(
                    icon = Icons.Default.Star,
                    title = "4.3"
                )

                TitledIcon(
                    icon = Icons.Default.AccessTime,
                    title = "178 min"
                )

                TitledIcon(
                    icon = Icons.Default.DateRange,
                    title = "19 Dec, 2001"
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = stringResource(id = R.string.summary),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )

            Text(
                text = movie.overview ?: movie.title ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
        }
    }
}