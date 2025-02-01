package me.ibrahim.moviesapp.compose.presentation.movies_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import coil3.compose.AsyncImage
import me.ibrahim.moviesapp.compose.BuildConfig
import me.ibrahim.moviesapp.compose.R
import me.ibrahim.moviesapp.compose.core.BaseActivity
import me.ibrahim.moviesapp.compose.domain.Movie
import me.ibrahim.moviesapp.compose.presentation.movies_detail.components.TitledIcon

class MovieDetailActivity : BaseActivity() {
    @Composable
    override fun InitView() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        MovieDetailScreen()
    }
}

@Preview
@Composable
fun MovieDetailScreen(
    movie: Movie = Movie(
        title = "The Gardener",
        id = 539972,
        posterPath = "${BuildConfig.POSTER_IMAGES_BASEURL}/5T9WR7vIOnHm6xhVt5zBuPbBgt1.jpg",
        overview = "Sonic, Knuckles, and Tails reunite against a powerful new adversary, Shadow, a mysterious villain with powers unlike anything they have faced before. With their abilities outmatched in every way, Team Sonic must seek out an unlikely alliance in hopes of stopping Shadow and protecting the planet."
    )
) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.matchParentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {

                AsyncImage(
                    model = movie.posterPath,
                    contentDescription = movie.title,
                    modifier = Modifier
                        .matchParentSize(),
                    alpha = 0.8f,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .align(Alignment.BottomCenter)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    colorResource(id = R.color.black2),
                                    colorResource(id = R.color.black1),
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            )
                        )
                )



                AsyncImage(
                    model = movie.posterPath,
                    contentDescription = movie.title,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(bottom = 10.dp)
                        .aspectRatio(ratio = 2 / 3f)
                        .clip(RoundedCornerShape(10.dp))
                        .border(
                            width = 1.dp, color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .align(Alignment.BottomCenter)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
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
                        text = "Summary",
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

        Image(painter = painterResource(id = R.drawable.bg1), contentDescription = null)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .statusBarsPadding()
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.back),
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = stringResource(id = R.string.back),
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
            )
        }
    }

}
