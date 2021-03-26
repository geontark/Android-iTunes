package com.devtak.watcha.data.datasource

import com.devtak.watcha.data.TrackData
import io.reactivex.Single

interface TrackDataSource {
    fun search(keyword: String, entity: String, limit: Int): Single<List<TrackData>>
}