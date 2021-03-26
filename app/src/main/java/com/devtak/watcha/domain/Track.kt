package com.devtak.watcha.domain

data class Track(
    val trackId: Long,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val artworkUrl: String
) {

    override fun toString(): String =
        """
            
            ## Track ##
            trackId : $trackId
            trackName : $trackName
            artistName : $artistName
            collectionName : $collectionName
            artworkUrl : $artworkUrl
            
        """.trimIndent()
}