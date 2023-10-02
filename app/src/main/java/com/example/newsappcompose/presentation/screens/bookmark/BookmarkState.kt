package com.example.newsappcompose.presentation.screens.bookmark

import com.example.newsappcompose.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)