package com.devtak.watcha.domain.usecase

import com.devtak.watcha.domain.Track
import com.devtak.watcha.domain.repository.FavoriteTrackRepository
import io.reactivex.Completable

class FavoriteTrackFocUseCase(private val favoriteTrackRepository: FavoriteTrackRepository) {
    operator fun invoke(track: Track): Completable
            = favoriteTrackRepository.favoriteTrackFoc(track = track)
}