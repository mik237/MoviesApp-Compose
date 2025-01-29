package me.ibrahim.moviesapp.compose.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import me.ibrahim.moviesapp.compose.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashScreenPrev() {
    SplashScreen(modifier = Modifier)
}

@Composable
fun SplashScreen(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blackBackground))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            HeaderSection()
            FooterSection()
        }
    }
}


@Composable
fun FooterSection() {
    ConstraintLayout {
        val (bg2, button) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.bg2),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .constrainAs(bg2) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Button(
            modifier = Modifier
                .size(200.dp, 50.dp)
                .constrainAs(button) {
                    top.linkTo(bg2.top)
                    bottom.linkTo(bg2.bottom)
                    start.linkTo(bg2.start)
                    end.linkTo(bg2.end)
                },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            border = BorderStroke(
                width = 4.dp,
                brush = Brush.linearGradient(
                    listOf(
                        colorResource(id = R.color.pink),
                        colorResource(id = R.color.green)
                    )
                )
            ),
            onClick = { }) {
            Text(
                text = "Get In",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}


@Composable
fun HeaderSection() {
    ConstraintLayout {
        val (bg1, women, title, description) = createRefs()

        val topGuideline = createGuidelineFromTop(0.1f)

        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = null,
            modifier = Modifier.constrainAs(bg1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.woman),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(women) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(20.dp)
        )

        Text(
            text = "Watch Videos in\nVirtual Reality",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(women.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Download and watch offline\nwhereever you are!",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.constrainAs(description) {
                top.linkTo(title.bottom, 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}