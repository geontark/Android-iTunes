package com.devtak.watcha.domain.repository

import com.devtak.watcha.domain.Track
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface FavoriteTrackRepository {
    fun observe(): Flowable<List<Track>>
    fun getAll(): Single<List<Track>>
    fun favoriteTrackFoc(track: Track): Completable
    fun favoriteTrackNor(trackId: Long): Completable
}