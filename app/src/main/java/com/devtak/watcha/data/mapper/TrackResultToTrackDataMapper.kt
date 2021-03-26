package com.devtak.watcha.data.mapper

import com.devtak.watcha.data.TrackData
import com.devtak.watcha.data.datasource.remote.TrackResult

fun trackResultToTrackDataMapper(trackResult: TrackResult) =
    TrackData(
        trackId = trackResult.trackId,
        trackName = trackResult.trackName,
        artistName = trackResult.artistName,
        collectionName = trackResult.collectionName,
        artworkUrl = trackResult.artworkUrl60
    )

fun trackResultToTrackDataMapper(tracksResult: List<TrackResult>) =
    tracksResult.map { trackResultToTrackDataMapper(it) }
