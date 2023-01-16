package com.arvindmehra.nasagallary.presentation.imageList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.arvindmehra.nasagallery.common.ImageMapper
import com.arvindmehra.nasagallery.presentation.Screen

@Composable
fun ImageListScreen(
    viewModel: ImageListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
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
            Box(Modifier.fillMaxSize().padding(it), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (state.error.isNotEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = state.error, color = MaterialTheme.colors.error)
            }
        } else {
            val images = state.imageList
            Box(Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(images.size) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                ImageRequest.Builder(LocalContext.current)
                                    .data(data = images[it].url)
                                    .apply(block = fun ImageRequest.Builder.() {
                                        transformations(RoundedCornersTransformation(radius = 12.0F))
                                    }).build()
                            ),
                            modifier = Modifier
                                .size(144.dp)
                                .clickable {
                                    val id = (1..1000).random().toString()
                                    ImageMapper.addIssue(id, images[it])
                                    navController.navigate(route = Screen.ImageDetailScreen.route + "/${id}")
                                },
                            contentDescription = "Profile picture description",
                        )
                    }
                }
            }
        }
    }
}