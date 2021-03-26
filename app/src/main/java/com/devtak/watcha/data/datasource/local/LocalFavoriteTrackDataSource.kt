package com.devtak.watcha.data.datasource.local

import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.data.TrackData
import com.devtak.watcha.data.datasource.FavoriteTrackDataSource
import com.devtak.watcha.data.mapper.favoriteTrackEntityToTrackDataMapper
import com.devtak.watcha.data.mapper.trackDataToFavoriteTrackEntityMapper
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class LocalFavoriteTrackDataSource(private val favoriteTrackDao: FavoriteTrackDao) :
    FavoriteTrackDataSource {
    override fun observe(): Flowable<List<TrackData>> =
        favoriteTrackDao.observe()
            .map(::favoriteTrackEntityToTrackDataMapper)
            .doOnError { Logg.e("$it") }

    override fun getAll(): Single<List<TrackData>> =
        favoriteTrackDao.selectAll()
            .map(::favoriteTrackEntityToTrackDataMapper)
            .doOnError { Logg.e("$it") }

    override fun favoriteFoc(trackData: TrackData): Completable =
        favoriteTrackDao.insert(favoriteTrackEntity = trackDataToFavoriteTrackEntityMapper(trackData = trackData))
            .doOnError { Logg.e("$it") }

    override fun favoriteNor(trackId: Long): Completable =
        favoriteTrackDao.deleteFindByTrackId(trackId = trackId)
            .doOnError { Logg.e("$it") }
}