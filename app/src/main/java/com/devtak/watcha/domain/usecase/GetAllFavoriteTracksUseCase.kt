package com.devtak.watcha.domain.usecase

import com.devtak.watcha.domain.Track
import com.devtak.watcha.domain.repository.FavoriteTrackRepository
import io.reactivex.Single

class GetAllFavoriteTracksUseCase(private val favoriteTrackRepository: FavoriteTrackRepository) {
    operator fun invoke(): Single<List<Track>> = favoriteTrackRepository.getAll()
}