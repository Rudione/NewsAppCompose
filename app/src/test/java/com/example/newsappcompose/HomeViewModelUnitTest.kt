package com.example.newsappcompose

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newsappcompose.domain.repository.NewsRepository
import com.example.newsappcompose.domain.usecases.news.DeleteArticleUseCase
import com.example.newsappcompose.domain.usecases.news.GetNewsUseCase
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import com.example.newsappcompose.domain.usecases.news.SearchNewsUseCase
import com.example.newsappcompose.domain.usecases.news.SelectArticleUseCase
import com.example.newsappcompose.domain.usecases.news.SelectArticlesUseCase
import com.example.newsappcompose.domain.usecases.news.UpsertArticleUseCase
import com.example.newsappcompose.presentation.screens.home.HomeViewModel
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeViewModelUnitTest {

    private val newsRepository: NewsRepository = TODO()

    val getNewsUseCase: GetNewsUseCase = GetNewsUseCase(newsRepository)
    val searchNewsUseCase: SearchNewsUseCase = SearchNewsUseCase(newsRepository)
    val selectUseCase: SelectArticlesUseCase = SelectArticlesUseCase(newsRepository)
    val upsertUseCase: UpsertArticleUseCase = UpsertArticleUseCase(newsRepository)
    val deleteUseCase: DeleteArticleUseCase = DeleteArticleUseCase(newsRepository)
    val selectArticleUseCase: SelectArticleUseCase
        get() {
            TODO()
        }

    private val newsUseCases: NewsUseCases = NewsUseCases(
        getNewsUseCase,
        searchNewsUseCase,
        selectUseCase,
        upsertUseCase,
        deleteUseCase,
        selectArticleUseCase
    )

    private val homeViewModel: HomeViewModel = HomeViewModel(newsUseCases)

    @Test
    fun homeViewModelTest_getNews() {
        var newsState = homeViewModel.state.value
        val news = homeViewModel.news
    }
}