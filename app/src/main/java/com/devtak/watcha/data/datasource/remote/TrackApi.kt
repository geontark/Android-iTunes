package com.devtak.watcha.data.datasource.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackApi {
    @GET("/search")
    fun search(
        @Query("term") term: String,
        @Query("entity") entity: String,
        @Query("limit") limit: Int, // 1 ~ 200
    ): Single<TracksResult>
}