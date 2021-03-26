package com.devtak.watcha.data.mapper

import com.devtak.watcha.data.TrackData
import com.devtak.watcha.domain.Track

fun trackToTrackDataMapper(track: Track): TrackData =
    TrackData(
        trackId = track.trackId,
        trackName = track.trackName,
        artistName = track.artistName,
        collectionName = track.collectionName,
        artworkUrl = track.artworkUrl
    )
