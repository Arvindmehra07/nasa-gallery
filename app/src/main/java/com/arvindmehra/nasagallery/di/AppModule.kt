package com.arvindmehra.nasagallery.di

import com.arvindmehra.nasagallery.BuildConfig
import com.arvindmehra.nasagallery.data.remote.NasaImageApi
import com.arvindmehra.nasagallery.data.repository.GalleryRepositoryImpl
import com.arvindmehra.nasagallery.domain.repository.GalleryRepository
import com.arvindmehra.nasagallery.domain.usecase.GetImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.hostnameVerifier { _, _ -> true }.build()
    }

    @Singleton
    @Provides
    fun providesGithubApi(okHttpClient: OkHttpClient): NasaImageApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaImageApi::class.java)
    }

    @Singleton
    @Provides
    fun providesGitRepository(githubApi: NasaImageApi): GalleryRepository {
        return GalleryRepositoryImpl(githubApi)
    }

    @Singleton
    @Provides
    fun providesGetIssueUseCase(repository: GalleryRepository): GetImageUseCase {
        return GetImageUseCase(repository = repository)
    }
}