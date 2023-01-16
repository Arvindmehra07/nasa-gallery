package com.arvindmehra.nasagallery.domain.repository

import com.arvindmehra.nasagallery.common.Resource
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
    suspend fun getImages() : Flow<Resource<List<NasaImage>>>
}