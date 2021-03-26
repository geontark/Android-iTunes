package com.devtak.watcha.data.datasource.remote

import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.data.TrackData
import com.devtak.watcha.data.datasource.TrackDataSource
import com.devtak.watcha.data.mapper.trackResultToTrackDataMapper
import io.reactivex.Single

class RemoteTrackDataSource(private val trackApi: TrackApi):
    TrackDataSource {
    override fun search(keyword: String, entity: String, limit: Int): Single<List<TrackData>> =
        trackApi.search(term = keyword, entity = entity, limit = limit)
            .map { trackResultToTrackDataMapper(it.results) }
            .doOnError { Logg.e("$it") }
}