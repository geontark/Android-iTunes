package com.devtak.watcha.data.datasource

import com.devtak.watcha.data.TrackData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface FavoriteTrackDataSource {
    fun observe(): Flowable<List<TrackData>>
    fun getAll(): Single<List<TrackData>>
    fun favoriteFoc(trackData: TrackData): Completable
    fun favoriteNor(trackId: Long): Completable
}