package com.example.newsappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsappcompose.domain.model.Article

/**
 * @property [NewsDatabase] class for database access.
 */
@Database(entities = [Article::class], version = 1)
@TypeConverters(NewsTypeConvertorImpl::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun newsDao(): NewsDao
}