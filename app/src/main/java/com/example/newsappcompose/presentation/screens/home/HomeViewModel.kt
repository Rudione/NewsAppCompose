package com.example.newsappcompose.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @property [HomeViewModel] class for home view model.
 * This class is responsible for handling the home view model.
 * @param newsUseCases
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val news = newsUseCases.getNewsUseCase(
        sources = listOf("bbc-news", "cnn", "fox-news", "google-news", "the-verge",),
    ).cachedIn(viewModelScope)

}