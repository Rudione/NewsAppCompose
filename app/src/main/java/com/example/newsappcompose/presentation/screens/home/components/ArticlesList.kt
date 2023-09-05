package com.example.newsappcompose.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.presentation.common.ArticleCard
import com.example.newsappcompose.presentation.common.EmptyScreen
import com.example.newsappcompose.presentation.common.shimmerEffect
import com.example.newsappcompose.presentation.utils.Dimens

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onItemClick: (Article) -> Unit
) {
    val handlePagingResult = HandlePagingResult(articles, onItemClick)

    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(articles.itemCount) {index ->
                articles[index].let {
                    ArticleCard(
                        article = it!!,
                        onClick = { onItemClick(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun HandlePagingResult(
    articles: LazyPagingItems<Article>,
    onItemClick: (Article) -> Unit
): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error)
            false
        }
        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier
                    .padding(horizontal = Dimens.MediumPadding1)
                    .shimmerEffect()
            )
        }
    }
}