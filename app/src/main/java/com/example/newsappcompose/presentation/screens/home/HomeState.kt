package com.example.newsappcompose.presentation.screens.home

/**
 * @property [HomeState] class for home state.
 * This class is responsible for holding the state of the home screen. It holds the news ticker and loading state.
 * @property newsTicker
 * @property isLoading
 */
data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)