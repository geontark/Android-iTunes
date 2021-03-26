package com.devtak.watcha.data.repositoryimpl

import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.data.datasource.local.LocalFavoriteTrackDataSource
import com.devtak.watcha.data.mapper.trackDataToTrackMapper
import com.devtak.watcha.data.mapper.trackToTrackDataMapper
import com.devtak.watcha.domain.Track
import com.devtak.watcha.domain.repository.FavoriteTrackRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class FavoriteTrackRepositoryImpl(private val localFavoriteTrackDataSource: LocalFavoriteTrackDataSource) :
    FavoriteTrackRepository {

    override fun observe(): Flowable<List<Track>> =
        localFavoriteTrackDataSource.observe()
            .map(::trackDataToTrackMapper)
            .doOnError { Logg.e("$it") }

    override fun getAll(): Single<List<Track>> =
        localFavoriteTrackDataSource.getAll()
            .map(::trackDataToTrackMapper)
            .doOnError { Logg.e("$it") }

    override fun favoriteTrackFoc(track: Track): Completable =
        localFavoriteTrackDataSource.favoriteFoc(trackData = trackToTrackDataMapper(track))
            .doOnError { Logg.e("$it") }

    override fun favoriteTrackNor(trackId: Long): Completable =
        localFavoriteTrackDataSource.favoriteNor(trackId = trackId)
            .doOnError { Logg.e("$it") }
}