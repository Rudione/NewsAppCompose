package com.example.newsappcompose.domain.usecases.app_entry

/**
 * @property [AppEntryUseCases] class for app entry use cases.
 */
data class AppEntryUseCases(
    val readAppEntryUseCase: ReadAppEntryUseCase,
    val saveAppEntryUseCase: SaveAppEntryUseCase
)