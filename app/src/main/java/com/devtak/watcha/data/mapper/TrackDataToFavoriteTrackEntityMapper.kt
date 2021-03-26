package com.devtak.watcha.data.mapper

import com.devtak.watcha.data.TrackData
import com.devtak.watcha.data.datasource.local.FavoriteTrackEntity

fun trackDataToFavoriteTrackEntityMapper(trackData: TrackData) =
    FavoriteTrackEntity(
        trackId = trackData.trackId,
        trackName = trackData.trackName,
        artistName = trackData.artistName,
        collectionName = trackData.collectionName,
        artworkUrl = trackData.artworkUrl
    )
