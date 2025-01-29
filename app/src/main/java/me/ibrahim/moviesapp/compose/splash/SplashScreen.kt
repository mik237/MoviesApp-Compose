package me.ibrahim.moviesapp.compose.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.ibrahim.moviesapp.compose.R
import me.ibrahim.moviesapp.compose.splash.components.FooterSection
import me.ibrahim.moviesapp.compose.splash.components.HeaderSection

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashScreenPrev() {
    SplashScreen(modifier = Modifier){}
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
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
            FooterSection {}
        }
    }
}





