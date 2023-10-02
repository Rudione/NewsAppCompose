package com.example.newsappcompose.domain.usecases.news

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val selectUseCase: SelectUseCase,
    val upsertUseCase: UpsertUseCase,
    val deleteUseCase: DeleteUseCase
)
