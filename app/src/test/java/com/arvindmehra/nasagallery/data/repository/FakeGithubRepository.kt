package com.arvindmehra.nasagallery.data.repository

import com.arvindmehra.nasagallery.common.Resource
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import com.arvindmehra.nasagallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGithubRepository : GalleryRepository {

    override suspend fun getImages(): Flow<Resource<List<NasaImage>>> = flow {
        emit(Resource.Loading(emptyList()))
        val imageList = listOf(NasaImage("title", "27-12-22", "This is vastness of space", "https://hdurl.com", "image"))
        emit(Resource.Success(imageList))
    }
}