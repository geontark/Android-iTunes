package com.devtak.watcha.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devtak.watcha.data.datasource.local.FavoriteTrackDao
import com.devtak.watcha.data.datasource.local.FavoriteTrackEntity

@Database(
    version = 1,
    entities = [FavoriteTrackEntity::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteTrackDao(): FavoriteTrackDao
}