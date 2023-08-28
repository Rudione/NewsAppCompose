package com.example.newsappcompose.presentation.screens.onboarding

import androidx.annotation.DrawableRes
import com.example.newsappcompose.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Welcome to News App",
        description = "This is a news app that uses News API to get the latest news from different sources.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Get the latest news",
        description = "Get the latest news from different sources.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Search for news",
        description = "Search for news from different sources.",
        image = R.drawable.onboarding3
    ),
)

