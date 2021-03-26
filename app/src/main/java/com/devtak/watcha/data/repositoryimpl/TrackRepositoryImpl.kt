package com.devtak.watcha.data.repositoryimpl

import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.data.datasource.remote.RemoteTrackDataSource
import com.devtak.watcha.data.mapper.trackDataToTrackMapper
import com.devtak.watcha.domain.Track
import com.devtak.watcha.domain.repository.TrackRepository
import io.reactivex.Single

class TrackRepositoryImpl(
    private val remoteTrackDataSource: RemoteTrackDataSource
) : TrackRepository {

    override fun search(keyword: String, entity: String, limit: Int): Single<List<Track>> =
        remoteTrackDataSource.search(keyword = keyword, entity = entity,  limit = limit)
            .map(::trackDataToTrackMapper)
            .doOnError { Logg.e("$it") }
}