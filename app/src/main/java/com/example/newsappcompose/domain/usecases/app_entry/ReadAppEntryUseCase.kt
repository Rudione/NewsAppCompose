package com.example.newsappcompose.domain.usecases.app_entry

import com.example.newsappcompose.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow

/**
 * @property [ReadAppEntryUseCase] class for reading app entry.
 */
class ReadAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserRepository.readAppEntry()
    }
}