package com.example.newsappcompose.presentation.screens.details

import com.example.newsappcompose.domain.model.Article

/**
 * @property [DetailsEvent] class for details event.
 * This class is responsible for holding the events of the details screen.
 */
sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect: DetailsEvent()

}