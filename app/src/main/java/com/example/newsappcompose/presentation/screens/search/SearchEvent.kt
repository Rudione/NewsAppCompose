package com.example.newsappcompose.presentation.screens.search

/**
 * @property [SearchEvent] class for search event.
 * This class is responsible for holding the events of the search screen.
 */
sealed class SearchEvent {

    data class UpdateSearchQuery(val query: String): SearchEvent()

    object SearchNews: SearchEvent()
}