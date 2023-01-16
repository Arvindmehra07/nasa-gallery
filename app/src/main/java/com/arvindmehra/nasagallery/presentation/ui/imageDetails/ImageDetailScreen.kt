package com.arvindmehra.nasagallary.presentation.imageDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage

@Composable
fun ImageDetailScreen(
    viewModel: ImageDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val image = state.image

    Scaffold(
        topBar = {
            Text(modifier = Modifier.padding(16.dp),
                text = "Nasa Gallery",
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
        }
    ) {
        if (state.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().padding(it)
            ) {
                CircularProgressIndicator(color = MaterialTheme.colors.onSurface)
            }
        } else if (state.error.isNotBlank()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Try again later!")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .padding(4.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = 0.dp
                ) {
                    AsyncImage(
                        model = image?.hdUrl,
                        contentDescription = "image",
                        modifier = Modifier.size(960.dp),
                        contentScale = ContentScale.Crop,
                    )
                }

                BottomContentComposable(image)
            }

        }
    }
}


@Composable
fun BottomContentComposable(image: NasaImage?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = image?.title ?: "",
            modifier = Modifier
                .wrapContentSize(),
            fontSize = 24.sp,
            fontWeight = FontWeight(400)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${image?.copyright ?: ""} - ${image?.date ?: ""}",
            modifier = Modifier
                .wrapContentSize(),
            fontSize = 12.sp,
            fontWeight = FontWeight(200)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = image?.explanation ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight(300)
        )
    }
}