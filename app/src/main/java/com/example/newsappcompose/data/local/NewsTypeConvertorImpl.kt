package com.example.newsappcompose.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsappcompose.domain.model.Source
import com.example.newsappcompose.domain.repository.NewsTypeConvertor

@ProvidedTypeConverter
class NewsTypeConvertorImpl: NewsTypeConvertor {

    @TypeConverter
    override fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    override fun stringToSource(source: String): Source {
        val (id, name) = source.split(",")
        return Source(id, name)
    }
}