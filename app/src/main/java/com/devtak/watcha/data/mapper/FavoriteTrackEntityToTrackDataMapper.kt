package com.devtak.watcha.data.mapper

import com.devtak.watcha.data.TrackData
import com.devtak.watcha.data.datasource.local.FavoriteTrackEntity

fun favoriteTrackEntityToTrackDataMapper(favoriteTrackEntity: FavoriteTrackEntity) =
    TrackData(
        trackId = favoriteTrackEntity.trackId,
        trackName = favoriteTrackEntity.trackName,
        artistName = favoriteTrackEntity.artistName,
        collectionName = favoriteTrackEntity.collectionName,
        artworkUrl = favoriteTrackEntity.artworkUrl,
    )

fun favoriteTrackEntityToTrackDataMapper(favoriteTracksEntity: List<FavoriteTrackEntity>): List<TrackData> =
    favoriteTracksEntity.map(::favoriteTrackEntityToTrackDataMapper)
