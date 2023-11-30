package com.example.newsappcompose.presentation.screens.search

import androidx.paging.PagingData
import com.example.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * @property [SearchState] class for search state.
 * This class is responsible for holding the state of the search screen.
 */
data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)