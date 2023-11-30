package com.example.newsappcompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * @property Interface for database access for [Article] related operations.
 */
@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM articles")
    fun getArticles(): Flow<List<Article>>

    @Query("SELECT * FROM articles WHERE url=:url")
    suspend fun getArticle(url: String): Article?

}