package com.devtak.watcha.presentation.mapper

import com.devtak.watcha.domain.Track
import com.devtak.watcha.presentation.model.TrackPresentation

fun trackToTrackPresentation(track: Track, isFavorite: Boolean = false): TrackPresentation =
    TrackPresentation(
        trackId = track.trackId,
        trackName = track.trackName,
        collectionName = track.collectionName,
        artistName = track.artistName,
        artworkUrl = track.artworkUrl,
        isFavorite = isFavorite
    )

fun trackToTrackPresentation(tracks: List<Track>): List<TrackPresentation> =
    tracks.map(::trackToTrackPresentation)

