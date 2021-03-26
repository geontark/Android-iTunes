package com.devtak.watcha.data.datasource.remote

data class TrackResult(
    val trackId: Long,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String
)
