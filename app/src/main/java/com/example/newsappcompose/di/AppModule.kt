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
import com.example.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsappcompose.domain.usecases.app_entry.ReadAppEntryUseCase
import com.example.newsappcompose.domain.usecases.app_entry.SaveAppEntryUseCase
import com.example.newsappcompose.domain.usecases.news.DeleteArticleUseCase
import com.example.newsappcompose.domain.usecases.news.GetNewsUseCase
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import com.example.newsappcompose.domain.usecases.news.SearchNewsUseCase
import com.example.newsappcompose.domain.usecases.news.SelectArticleUseCase
import com.example.newsappcompose.domain.usecases.news.SelectArticlesUseCase
import com.example.newsappcompose.domain.usecases.news.UpsertArticleUseCase
import com.example.newsappcompose.domain.utils.Constants.BASE_URL
import com.example.newsappcompose.domain.utils.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @property [AppModule] class for providing dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * @param application
     * @return
     */
    @Provides
    @Singleton
    fun provideLocalUserRepository(
        application: Application
    ): LocalUserRepository = LocalUserRepositoryImpl(application)

    /**
     * @param localUserRepository
     * @return [AppEntryUseCases]
     */
    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserRepository: LocalUserRepository
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserRepository),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserRepository)
    )

    /**
     * @return [NewsApi] instance.
     */
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    /**
     * @param newsApi
     * @param newsDao
     * @return [NewsRepositoryImpl]
     */
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    /**
     * @param newsRepository
     * @return [NewsUseCases]
     */
    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNewsUseCase = GetNewsUseCase(newsRepository),
            searchNewsUseCase = SearchNewsUseCase(newsRepository),
            upsertUseCase = UpsertArticleUseCase(newsRepository),
            deleteUseCase = DeleteArticleUseCase(newsRepository),
            selectUseCase = SelectArticlesUseCase(newsRepository),
            selectArticleUseCase = SelectArticleUseCase(newsRepository)
        )
    }

    /**
     * @param application
     * @return [NewsDatabase]
     */
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

    /**
     * @param newsDatabase
     * @return [NewsDao]
     */
    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao()
}