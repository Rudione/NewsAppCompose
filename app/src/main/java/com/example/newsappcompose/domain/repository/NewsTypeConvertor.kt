package com.example.newsappcompose.domain.repository

import com.example.newsappcompose.domain.model.Source

interface NewsTypeConvertor {

    fun sourceToString(source: Source): String

    fun stringToSource(source: String): Source
}