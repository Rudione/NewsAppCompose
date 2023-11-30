package com.example.newsappcompose.data.remote

import com.example.newsappcompose.data.remote.dto.NewsResponse
import com.example.newsappcompose.domain.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @property [NewsApi] interface for news api.
 */
interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}
