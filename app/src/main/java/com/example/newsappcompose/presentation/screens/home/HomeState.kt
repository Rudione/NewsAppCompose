package com.example.newsappcompose.presentation.screens.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)