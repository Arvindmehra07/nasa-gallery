package com.arvindmehra.nasagallery.data.remote

import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import retrofit2.http.GET

interface NasaImageApi {
    @GET("obvious/take-home-exercise-data/trunk/nasa-pictures.json")
    suspend fun getImages(): List<NasaImage>
}