package com.example.newsappcompose.di

import android.app.Application
import androidx.room.Room
import com.example.newsappcompose.data.local.NewsDao
import com.example.newsappcompose.data.local.NewsDatabase
import com.example.newsappcompose.data.local.NewsTypeConvertorImpl
import com.example.newsappcompose.data.remote.NewsApi
import com.example.newsappcompose.data.repository.LocalUserRepositoryImpl
import com.example.newsappcompose.data.repository.NewsRepositoryImpl
import com.example.newsappcompose.domain.repository.LocalUserRepository
import com.example.newsappcompose.domain.repository.NewsRepository
import com.example.newsappcompose.domain.repository.NewsTypeConvertor
import com.example.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsappcompose.domain.usecases.app_entry.ReadAppEntryUseCase
import com.example.newsappcompose.domain.usecases.app_entry.SaveAppEntryUseCase
import com.example.newsappcompose.domain.usecases.news.DeleteUseCase
import com.example.newsappcompose.domain.usecases.news.GetNewsUseCase
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import com.example.newsappcompose.domain.usecases.news.SearchNewsUseCase
import com.example.newsappcompose.domain.usecases.news.SelectUseCase
import com.example.newsappcompose.domain.usecases.news.UpsertUseCase
import com.example.newsappcompose.domain.utils.Constants.BASE_URL
import com.example.newsappcompose.domain.utils.Constants.NEWS_DATABASE_NAME
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
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNewsUseCase = GetNewsUseCase(newsRepository),
            searchNewsUseCase = SearchNewsUseCase(newsRepository),
            upsertUseCase = UpsertUseCase(newsDao),
            deleteUseCase = DeleteUseCase(newsDao),
            selectUseCase = SelectUseCase(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertorImpl())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao()
}