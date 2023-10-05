package com.example.newsappcompose.presentation.screens.details

import com.example.newsappcompose.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect: DetailsEvent()

}