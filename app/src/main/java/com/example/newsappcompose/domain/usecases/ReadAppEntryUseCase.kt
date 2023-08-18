package com.example.newsappcompose.domain.usecases

import com.example.newsappcompose.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserRepository.readAppEntry()
    }
}