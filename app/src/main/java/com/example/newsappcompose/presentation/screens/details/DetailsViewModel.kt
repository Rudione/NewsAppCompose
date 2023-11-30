package com.example.newsappcompose.presentation.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @property [DetailsViewModel] class for details view model.
 * This class is responsible for handling the details view model.
 * @param newsUseCases
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    var sideEffect = mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when(event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCases.selectArticleUseCase(event.article.url)
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect.value = null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteUseCase(article)
        sideEffect.value = "Article deleted"
    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertUseCase(article)
        sideEffect.value = "Article saved"
    }
}