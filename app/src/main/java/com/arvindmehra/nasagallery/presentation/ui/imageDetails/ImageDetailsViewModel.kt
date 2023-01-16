package com.arvindmehra.nasagallary.presentation.imageDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.arvindmehra.nasagallery.common.ImageMapper
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(ImageDetailsState())
    val state = _state

    init {
        savedStateHandle.get<String>("image_id")?.let { image ->
            _state.value = ImageDetailsState(image = getImageById(image = image))
        }
    }

    private fun getImageById(image: String): NasaImage? {
        return ImageMapper.getIssue(image)
    }
}