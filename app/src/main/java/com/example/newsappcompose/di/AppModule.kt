package com.example.newsappcompose.di

import android.app.Application
import com.example.newsappcompose.data.remote.NewsApi
import com.example.newsappcompose.data.repository.LocalUserRepositoryImpl
import com.example.newsappcompose.data.repository.NewsRepositoryImpl
import com.example.newsappcompose.domain.repository.LocalUserRepository
import com.example.newsappcompose.domain.repository.NewsRepository
import com.example.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsappcompose.domain.usecases.app_entry.ReadAppEntryUseCase
import com.example.newsappcompose.domain.usecases.app_entry.SaveAppEntryUseCase
import com.example.newsappcompose.domain.usecases.news.GetNewsUseCase
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import com.example.newsappcompose.domain.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserRepository(
        application: Application
    ): LocalUserRepository = LocalUserRepositoryImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserRepository: LocalUserRepository
    ) = AppEntryUseCases(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserRepository),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserRepository)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNewsUseCase = GetNewsUseCase(newsRepository)
        )
    }
}