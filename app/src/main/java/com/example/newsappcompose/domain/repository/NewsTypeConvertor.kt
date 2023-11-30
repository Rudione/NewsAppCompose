package com.example.newsappcompose.domain.repository

import com.example.newsappcompose.domain.model.Source

/**
 * @property [NewsTypeConvertor] class for converting source to string and vice versa.
 */
interface NewsTypeConvertor {

    fun sourceToString(source: Source): String

    fun stringToSource(source: String): Source
}