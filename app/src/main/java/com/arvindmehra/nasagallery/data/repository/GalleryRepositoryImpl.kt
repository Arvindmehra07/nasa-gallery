package com.arvindmehra.nasagallery.data.repository

import com.arvindmehra.nasagallery.common.Resource
import com.arvindmehra.nasagallery.data.remote.NasaImageApi
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import com.arvindmehra.nasagallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val nasaImageApi: NasaImageApi
) : GalleryRepository {
    override suspend fun getImages(): Flow<Resource<List<NasaImage>>> = flow {
        emit(Resource.Loading())
       try{
           val images = nasaImageApi.getImages()
           emit(Resource.Success(images))
       }catch (e:Exception){
           emit(Resource.Error("Something went wrong!"))
       }
    }
}