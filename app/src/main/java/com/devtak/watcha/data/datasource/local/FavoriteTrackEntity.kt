package com.devtak.watcha.data.datasource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "favoriteTrack")
data class FavoriteTrackEntity(
    @PrimaryKey
    val trackId: Long,

    @ColumnInfo(name = "trackName")
    @NotNull
    val trackName: String,

    @ColumnInfo(name = "artistName")
    @NotNull
    val artistName: String,

    @ColumnInfo(name = "collectionName")
    @NotNull
    val collectionName: String,

    @ColumnInfo(name = "artworkUrl")
    @NotNull
    val artworkUrl: String
) {

    override fun toString(): String =
        """
            
            ## FavoriteTrackEntity ##
            trackId : $trackId
            trackName : $trackName
            artistName : $artistName
            collectionName : $collectionName
            artworkUrl : $artworkUrl
            
        """.trimIndent()
}