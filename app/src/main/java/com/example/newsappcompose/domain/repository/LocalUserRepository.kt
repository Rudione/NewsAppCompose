package com.example.newsappcompose.domain.repository

import kotlinx.coroutines.flow.Flow

/**
 * @property [LocalUserRepository] class for saving and reading app entry.
 */
interface LocalUserRepository {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}