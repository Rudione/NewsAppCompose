package com.example.newsappcompose.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * @property [GetNewsUseCase] class for getting news.
 */
class GetNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}