package com.example.newsappcompose.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    val news = newsUseCases.getNewsUseCase(
        sources = listOf("bbc-news", "cnn", "fox-news", "google-news", "the-verge")
    ).cachedIn(viewModelScope)
}