package com.arvindmehra.nasagallary.presentation.imageList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arvindmehra.nasagallery.common.Resource
import com.arvindmehra.nasagallery.domain.repository.GalleryRepository
import com.arvindmehra.nasagallery.domain.usecase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase
): ViewModel() {

    private val _state = mutableStateOf(ImageListState())
    val state = _state

    init {
        viewModelScope.launch(IO) { getImages() }
    }

    private suspend fun getImages() {
        getImageUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ImageListState(imageList = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = ImageListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = ImageListState(error = "Was not able to fetch data. Try again.")
                }
            }
        }.launchIn(viewModelScope)
    }
}