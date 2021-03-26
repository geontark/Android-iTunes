package com.devtak.watcha.presentation.model

data class TrackPresentation(
    val trackId: Long,
    val trackName: String,
    val collectionName: String,
    val artistName: String,
    val artworkUrl: String,
    var isFavorite: Boolean = false
) {
    override fun toString(): String =
        """
            
            ## TrackPresentation ##
            trackId : $trackId
            trackName : $trackName
            collectionName : $collectionName
            artistName : $artistName
            artwork : $artworkUrl
            isFavorite : $isFavorite
            
        """.trimIndent()

}
