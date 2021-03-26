package com.devtak.watcha.data.datasource

import com.devtak.watcha.data.datasource.remote.TrackApi
import com.devtak.watcha.data.datasource.remote.TracksResult
import io.reactivex.Single

class FakeTrackApi(private val tracksResult: TracksResult) : TrackApi {

    override fun search(term: String, entity: String, limit: Int): Single<TracksResult> =
        Single.just(tracksResult)

}