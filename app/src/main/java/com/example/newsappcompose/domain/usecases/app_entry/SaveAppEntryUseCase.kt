package com.example.newsappcompose.domain.usecases.app_entry

import com.example.newsappcompose.domain.repository.LocalUserRepository

class SaveAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
    suspend operator fun invoke() {
        localUserRepository.saveAppEntry()
    }
}