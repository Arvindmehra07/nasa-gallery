package com.arvindmehra.nasagallery.data.usecase

import com.arvindmehra.nasagallery.common.Resource
import com.arvindmehra.nasagallery.data.remote.dto.NasaImage
import com.arvindmehra.nasagallery.data.repository.FakeGithubRepository
import com.arvindmehra.nasagallery.domain.repository.GalleryRepository
import com.arvindmehra.nasagallery.domain.usecase.GetImageUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class GetImageUseCaseTest {
    private lateinit var SUT: GetImageUseCase
    private lateinit var repository: GalleryRepository

    @Before
    fun setUp() {
        repository = FakeGithubRepository()
        SUT = GetImageUseCase(repository = repository)
    }

    @Test
    fun `getImageList flowEmitsLoading`() = runTest {
        val first = SUT().take(1).first()
        assertThat((first as (Resource.Loading<*>)).data, `is`(emptyList<NasaImage>()))
    }

    @Test
    fun `getImageList flow emits first item`() = runTest {
        val first = SUT().drop(1).first()
        assertThat(
            (first as (Resource.Success<*>)).data,
            `is`(listOf(NasaImage("title", "27-12-22", "This is vastness of space", "https://hdurl.com", "image")))
        )
    }
}