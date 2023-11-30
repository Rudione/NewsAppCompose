package com.example.newsappcompose.presentation.screens.bookmark

import com.example.newsappcompose.domain.model.Article

/**
 * @property [BookmarkState] class for bookmark state.
 * This class is responsible for holding the state of the bookmark screen. It holds the list of articles.
 * @property articles
 */
data class BookmarkState(
    val articles: List<Article> = emptyList()
)