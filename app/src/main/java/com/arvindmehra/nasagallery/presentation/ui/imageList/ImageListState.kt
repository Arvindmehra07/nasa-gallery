package com.arvindmehra.nasagallary.presentation.imageList

import com.arvindmehra.nasagallery.data.remote.dto.NasaImage

data class ImageListState (
    val isLoading : Boolean = false,
    val error : String = "",
    val imageList : List<NasaImage> = emptyList()
)