package com.example.newsappcompose.domain.usecases.news

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val selectUseCase: SelectArticlesUseCase,
    val upsertUseCase: UpsertArticleUseCase,
    val deleteUseCase: DeleteArticleUseCase,
    val selectArticleUseCase: SelectArticleUseCase
)
