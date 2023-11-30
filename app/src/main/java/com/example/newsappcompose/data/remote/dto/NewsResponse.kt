package com.example.newsappcompose.data.remote.dto

import android.os.Parcelable
import com.example.newsappcompose.domain.model.Article
import kotlinx.parcelize.Parcelize

/**
 * @property [NewsResponse] class for response from news api.
 */
@Parcelize
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
): Parcelable