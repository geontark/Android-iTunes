package com.devtak.watcha.domain.usecase

import com.devtak.watcha.domain.repository.FavoriteTrackRepository
import io.reactivex.Completable

class FavoriteTrackNorUseCase(private val favoriteTrackRepository: FavoriteTrackRepository) {
    operator fun invoke(trackId: Long): Completable
            = favoriteTrackRepository.favoriteTrackNor(trackId = trackId)
}