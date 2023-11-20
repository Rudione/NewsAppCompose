package com.example.newsappcompose.presentation.screens.search

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = event.query)
            }

            is SearchEvent.SearchNews -> {
                searchNews()
            }
        }
    }

    private fun searchNews() {
        viewModelScope.launch {
            try {
                val articles = newsUseCases.searchNewsUseCase(
                    searchQuery = state.value.searchQuery,
                    sources = listOf(
                        "bbc-news",
                        "cnn",
                        "fox-news",
                        "google-news",
                        "the-washington-post"
                    )
                ).cachedIn(viewModelScope)
                _state.value = state.value.copy(articles = articles)
                Log.d("SearchVM", "searchNews success: ${_state.value.articles}")
            } catch (e: Exception) {
                Log.e("SearchVM", "searchNews error: ${e.message}", e)
            }
        }
    }

}