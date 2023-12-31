package com.example.newsappcompose.domain.usecases.news

import com.example.newsappcompose.data.local.NewsDao
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.domain.repository.NewsRepository

/**
 * @property [UpsertArticleUseCase] class for upserting article.
 *
 * @property newsRepository
 */
class UpsertArticleUseCase(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}