package com.devtak.watcha.domain.usecase

import com.devtak.watcha.domain.Track
import com.devtak.watcha.domain.repository.TrackRepository
import io.reactivex.Single

class SearchTracksUseCase(private val trackRepository: TrackRepository) {
    operator fun invoke(keyword: String, entity: String, limit: Int): Single<List<Track>>
    = trackRepository.search(keyword = keyword, entity = entity, limit = limit)
}