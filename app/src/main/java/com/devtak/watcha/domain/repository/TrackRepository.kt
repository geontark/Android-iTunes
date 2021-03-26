package com.devtak.watcha.domain.repository

import com.devtak.watcha.domain.Track
import io.reactivex.Single

interface TrackRepository {
    fun search(
        keyword: String,
        entity: String,
        limit: Int = 30,
    ): Single<List<Track>>
}