package com.devtak.watcha.presentation.mapper

import com.devtak.watcha.domain.Track
import com.devtak.watcha.presentation.model.TrackPresentation

fun trackPresentationToTrack(trackPresentation: TrackPresentation): Track =
    Track(
        trackId = trackPresentation.trackId,
        trackName = trackPresentation.trackName,
        artistName = trackPresentation.artistName,
        collectionName = trackPresentation.collectionName,
        artworkUrl = trackPresentation.artworkUrl
    )