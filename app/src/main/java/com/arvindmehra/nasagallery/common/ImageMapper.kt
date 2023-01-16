package com.arvindmehra.nasagallery.common

import com.arvindmehra.nasagallery.data.remote.dto.NasaImage

object ImageMapper {
    private val issueMap = mutableMapOf<String, NasaImage>()

    fun addIssue(id: String, image: NasaImage) {
        issueMap.put(id, image)
    }

    fun getIssue(id: String): NasaImage? = issueMap.getOrDefault(id, null)

}