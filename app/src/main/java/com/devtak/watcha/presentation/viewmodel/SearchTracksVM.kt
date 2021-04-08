package com.devtak.watcha.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devtak.watcha.R
import com.devtak.watcha.core.livedata.ListLiveData
import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.core.network.NetworkHandler
import com.devtak.watcha.core.wrapper.Event
import com.devtak.watcha.domain.usecase.FavoriteTrackFocUseCase
import com.devtak.watcha.domain.usecase.FavoriteTrackNorUseCase
import com.devtak.watcha.domain.usecase.GetAllFavoriteTracksUseCase
import com.devtak.watcha.domain.usecase.SearchTracksUseCase
import com.devtak.watcha.presentation.mapper.trackPresentationToTrack
import com.devtak.watcha.presentation.mapper.trackToTrackPresentation
import com.devtak.watcha.presentation.model.TrackPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchTracksVM(
    private val networkHandler: NetworkHandler,
    private val searchTrackUseCase: SearchTracksUseCase,
    private val getAllFavoriteTracksUseCase: GetAllFavoriteTracksUseCase,
    private val favoriteTrackFocUseCase: FavoriteTrackFocUseCase,
    private val favoriteTrackNorUseCase: FavoriteTrackNorUseCase
) : TracksVM() {
    // 검색목록 갱신
    private val _searchRefreshDoneEvent = MutableLiveData<Event<Unit>>()
    val searchRefreshDoneEvent = _searchRefreshDoneEvent

    private val _searchTracks = ListLiveData<TrackPresentation>()
    val searchTracks: LiveData<ArrayList<TrackPresentation>> = _searchTracks
    // 검색 키워드 고정
    private val keyword = "greenday"
    private val entity = "song"
    private val limit = 200

    init {
        searchTrack()
    }

    fun favoriteUpdate() {
        val list = _searchTracks.value ?: return
        favoriteUpdate(ArrayList(list))
    }

    // search track 항목들에서 favorite 항목들 업데이트하기
    private fun favoriteUpdate(list: ArrayList<TrackPresentation>) {
        getAllFavoriteTracksUseCase()
            .map(::trackToTrackPresentation)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val set = HashSet<Long>()
                for (index in 0 until it.count()) {
                    val trackId = it[index].trackId
                    set.add(trackId)
                }
                for (index in 0 until list.count()) {
                    list[index].isFavorite = set.contains(list[index].trackId)
                }
                _searchTracks.value = list
                searchRefreshDone()
            }, {
                searchRefreshDone()
                Logg.e("$it")
            }).also {
                addDisposable(it)
            }
    }

    fun searchTrack() {
        // network check
        if (!networkHandler.isNetworkAvailable()) {
            Logg.e("로그 출력해보자!!!!")
            showToast(R.string.toast_error_network)
            searchRefreshDone()
            return
        }

        searchTrackUseCase(keyword = keyword, entity = entity, limit = limit)
            .map(::trackToTrackPresentation)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                favoriteUpdate(ArrayList(it))
            }, {
                searchRefreshDone()
                Logg.e("$it")
            }).also {
                addDisposable(dispose = it)
            }
    }

    fun addFavorteTrack(index: Int) {
        val trackPresentation = searchTracks.value?.get(index) ?: return
        favoriteTrackFocUseCase(track = trackPresentationToTrack(trackPresentation))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                trackPresentation.isFavorite = trackPresentation.isFavorite.not()
                _searchTracks.replace(index, trackPresentation)
            }, {
                Logg.e("$it")
            }).also {
                addDisposable(dispose = it)
            }
    }

    fun deleteFavoriteTrack(index: Int) {
        val trackPresentation = searchTracks.value?.get(index) ?: return
        favoriteTrackNorUseCase(trackId = trackPresentation.trackId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                trackPresentation.isFavorite = trackPresentation.isFavorite.not()
                _searchTracks.replace(index, trackPresentation)
            }, {
                Logg.e("$it")
            }).also {
                addDisposable(dispose = it)
            }
    }

    private fun searchRefreshDone() {
        _searchRefreshDoneEvent.value = Event(Unit)
    }

}