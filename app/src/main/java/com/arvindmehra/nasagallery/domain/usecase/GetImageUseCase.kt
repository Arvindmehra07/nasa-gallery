package com.arvindmehra.nasagallery.domain.usecase

import com.arvindmehra.nasagallery.common.Resource
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import com.arvindmehra.nasagallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: GalleryRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<NasaImage>>> {
        return repository.getImages()
    }
}