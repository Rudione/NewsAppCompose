package com.example.newsappcompose.presentation.screens.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val query: String): SearchEvent()

    object SearchNews: SearchEvent()
}