package com.devtak.watcha.data.datasource

import com.devtak.watcha.data.datasource.remote.RemoteTrackDataSource
import com.devtak.watcha.data.datasource.remote.TrackResult
import com.devtak.watcha.data.datasource.remote.TracksResult
import org.junit.Before
import org.junit.Test

class RemoteTrackDataSourceTest {
    lateinit var remoteTrackDataSource: RemoteTrackDataSource
    lateinit var tracksData: List<TrackResult>
    @Before
    fun init() {
        tracksData = listOf<TrackResult>(
            TrackResult(
                trackId = 100000,
                trackName = "track name1",
                artistName = "artist name1",
                collectionName = "collection name1",
                artworkUrl60 = "https://abc.com/aaa.jpg"
            ),
            TrackResult(
                trackId = 200000,
                trackName = "track name2",
                artistName = "artist name2",
                collectionName = "collection name3",
                artworkUrl60 = "https://abc.com/bbb.jpg"
            ),
            TrackResult(
                trackId = 300000,
                trackName = "track name3",
                artistName = "artist name3",
                collectionName = "collection name3",
                artworkUrl60 = "https://abc.com/ccc.jpg"
            )
        )

        val tracksResult = TracksResult(
            resultCont = 20,
            results = tracksData
        )
        val fakeTrackApi = FakeTrackApi(tracksResult = tracksResult)
        remoteTrackDataSource = RemoteTrackDataSource(trackApi = fakeTrackApi)
    }

    @Test
    fun `Test for successful call to search function in datastore`() {
        remoteTrackDataSource.search(keyword = "keyword", entity = "entity", limit = 3)
            .test()
            .assertSubscribed()
            .assertValue {
                it.count() == tracksData.count() &&
                        it[0].trackId == tracksData[0].trackId &&
                        it[1].trackId == tracksData[1].trackId &&
                        it[2].trackId == tracksData[2].trackId
            }
            .assertComplete()
            .assertNoErrors()
    }
}