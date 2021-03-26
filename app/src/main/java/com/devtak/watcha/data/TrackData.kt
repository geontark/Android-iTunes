package com.devtak.watcha.data

data class TrackData(
    val trackId: Long,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val artworkUrl: String
) {

    override fun toString(): String =
        """
            
            ## TrackData ##
            trackId: $trackId
            trackName: $trackName
            artistName: $artistName
            collectionName: $collectionName
            artworkUrl: $artworkUrl
            
        """.trimIndent()
}