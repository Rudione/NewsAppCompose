package com.example.newsappcompose.di

import android.content.Context
import com.example.newsappcompose.NewsAppApplication
import com.example.newsappcompose.data.repository.LocalUserRepositoryImpl
import com.example.newsappcompose.domain.repository.LocalUserRepository
import com.example.newsappcompose.domain.usecases.AppEntryUseCases
import com.example.newsappcompose.domain.usecases.ReadAppEntryUseCase
import com.example.newsappcompose.domain.usecases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserRepository(
        application: NewsAppApplication
    ): LocalUserRepository {
        return LocalUserRepositoryImpl(application)
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserRepository: LocalUserRepository
    ) = AppEntryUseCases(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserRepository),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserRepository)
    )
}