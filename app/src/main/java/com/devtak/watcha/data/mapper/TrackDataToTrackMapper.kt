package com.devtak.watcha.data.mapper

import com.devtak.watcha.data.TrackData
import com.devtak.watcha.domain.Track

fun trackDataToTrackMapper(trackData: TrackData): Track =
    Track(
        trackId = trackData.trackId,
        trackName = trackData.trackName,
        artistName = trackData.artistName,
        collectionName = trackData.collectionName,
        artworkUrl = trackData.artworkUrl
    )

fun trackDataToTrackMapper(tracksData: List<TrackData>): List<Track> =
    tracksData.map(::trackDataToTrackMapper)