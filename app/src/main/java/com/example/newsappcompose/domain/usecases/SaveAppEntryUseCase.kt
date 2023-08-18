package com.example.newsappcompose.domain.usecases

import com.example.newsappcompose.domain.repository.LocalUserRepository

class SaveAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
    suspend operator fun invoke() {
        localUserRepository.saveAppEntry()
    }
}