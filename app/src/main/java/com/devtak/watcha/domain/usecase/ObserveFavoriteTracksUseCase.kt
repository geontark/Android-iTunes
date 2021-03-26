package com.devtak.watcha.domain.usecase

import com.devtak.watcha.domain.Track
import com.devtak.watcha.domain.repository.FavoriteTrackRepository
import io.reactivex.Flowable

class ObserveFavoriteTracksUseCase(private val favoriteTrackRepository: FavoriteTrackRepository) {
    operator fun invoke(): Flowable<List<Track>>
    = favoriteTrackRepository.observe()
}