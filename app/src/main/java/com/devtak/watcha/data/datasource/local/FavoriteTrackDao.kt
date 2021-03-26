package com.devtak.watcha.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface FavoriteTrackDao {
    @Query("SELECT * FROM favoriteTrack")
    fun observe(): Flowable<List<FavoriteTrackEntity>>

    @Query("SELECT * FROM favoriteTrack")
    fun selectAll(): Single<List<FavoriteTrackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteTrackEntity: FavoriteTrackEntity): Completable

    @Query("DELETE FROM favoriteTrack WHERE trackId = :trackId")
    fun deleteFindByTrackId(trackId: Long): Completable
}