package com.example.newsappcompose.presentation.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.newsappcompose.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    var sideEffect = mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when(event) {
            is DetailsEvent.SaveArticle -> {
                
            }
        }
    }
}