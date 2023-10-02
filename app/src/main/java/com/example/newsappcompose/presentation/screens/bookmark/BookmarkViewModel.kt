package com.example.newsappcompose.presentation.screens.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    private fun getArticles() {
        newsUseCases.selectUseCase().onEach {
            _state.value = state.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }
}