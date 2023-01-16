package com.arvindmehra.nasagallary.presentation.imageDetails

import com.arvindmehra.nasagallery.data.remote.dto.NasaImage


data class ImageDetailsState(
    val image : NasaImage? = null,
    val isLoading : Boolean = false,
    val error : String = "",
)
