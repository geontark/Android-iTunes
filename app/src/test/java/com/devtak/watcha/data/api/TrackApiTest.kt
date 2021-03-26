package com.devtak.watcha.data.api

import com.devtak.watcha.BuildConfig
import com.devtak.watcha.core.provideRetrofit
import com.devtak.watcha.data.datasource.remote.TrackApi
import org.junit.Before
import org.junit.Test

class TrackApiTest {
    lateinit var trackApi: TrackApi
    private val term = "greenday"
    private val entity =  "song"
    private val limit = 100

    @Before
    fun init() {
        trackApi = provideRetrofit(baseURL = BuildConfig.ITUNES_API).create(TrackApi::class.java)
    }

    @Test
    fun `Test to confirm success after requesting search api once`() {
        trackApi.search(term = term, entity = entity, limit = limit)
            .test()
            .assertSubscribed()
            .assertValue {
                it.results.count() == limit
            }
            .assertComplete()
            .assertNoErrors()
    }

}