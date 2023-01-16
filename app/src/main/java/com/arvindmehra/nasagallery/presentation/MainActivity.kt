package com.arvindmehra.nasagallery.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.arvindmehra.nasagallery.presentation.ui.theme.NasaGalleryTheme
import com.arvindmehra.nasagallary.presentation.imageDetails.ImageDetailScreen
import com.arvindmehra.nasagallary.presentation.imageList.ImageListScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.ImageListScreen.route
                    ) {
                        composable(Screen.ImageListScreen.route,
                            enterTransition = {
                                when (initialState.destination.route) {
                                    Screen.ImageDetailScreen.route ->
                                        slideIntoContainer(
                                            AnimatedContentScope.SlideDirection.Left,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            },
                            exitTransition = {
                                when (targetState.destination.route) {
                                    Screen.ImageDetailScreen.route ->
                                        slideOutOfContainer(
                                            AnimatedContentScope.SlideDirection.Left,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            },
                            popEnterTransition = {
                                when (initialState.destination.route) {
                                    Screen.ImageDetailScreen.route ->
                                        slideIntoContainer(
                                            AnimatedContentScope.SlideDirection.Right,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            },
                            popExitTransition = {
                                when (targetState.destination.route) {
                                    Screen.ImageDetailScreen.route ->
                                        slideOutOfContainer(
                                            AnimatedContentScope.SlideDirection.Right,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            }) {
                            ImageListScreen(navController = navController)
                        }
                        composable(Screen.ImageDetailScreen.route + "/{image_id}",
                            enterTransition = {
                                when (initialState.destination.route) {
                                    Screen.ImageListScreen.route ->
                                        slideIntoContainer(
                                            AnimatedContentScope.SlideDirection.Left,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            },
                            exitTransition = {
                                when (targetState.destination.route) {
                                    Screen.ImageListScreen.route ->
                                        slideOutOfContainer(
                                            AnimatedContentScope.SlideDirection.Left,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            },
                            popEnterTransition = {
                                when (initialState.destination.route) {
                                    Screen.ImageListScreen.route ->
                                        slideIntoContainer(
                                            AnimatedContentScope.SlideDirection.Right,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            },
                            popExitTransition = {
                                when (targetState.destination.route) {
                                    Screen.ImageListScreen.route ->
                                        slideOutOfContainer(
                                            AnimatedContentScope.SlideDirection.Right,
                                            animationSpec = tween(700)
                                        )
                                    else -> null
                                }
                            }) {
                            ImageDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
