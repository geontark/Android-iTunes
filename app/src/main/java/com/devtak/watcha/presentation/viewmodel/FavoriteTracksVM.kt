package com.devtak.watcha.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.devtak.watcha.core.livedata.ListLiveData
import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.domain.usecase.FavoriteTrackFocUseCase
import com.devtak.watcha.domain.usecase.FavoriteTrackNorUseCase
import com.devtak.watcha.domain.usecase.GetAllFavoriteTracksUseCase
import com.devtak.watcha.presentation.mapper.trackPresentationToTrack
import com.devtak.watcha.presentation.mapper.trackToTrackPresentation
import com.devtak.watcha.presentation.model.TrackPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavoriteTracksVM(
    private val favoriteTrackFocUseCase: FavoriteTrackFocUseCase,
    private val favoriteTrackNorUseCase: FavoriteTrackNorUseCase,
    private val getAllFavoriteTracksUseCase: GetAllFavoriteTracksUseCase
) : TracksVM() {
    private val _favoriteTracks = ListLiveData<TrackPresentation>()
    val favoriteTracks: LiveData<ArrayList<TrackPresentation>> = _favoriteTracks

    fun getAllFavoriteTracks() {
        getAllFavoriteTracksUseCase()
            .map {
                it.map { track ->
                    trackToTrackPresentation(track = track, isFavorite = true)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _favoriteTracks.value = ArrayList(it)
            }, {
                Logg.e("$it")
            }).also {
                addDisposable(dispose = it)
            }
    }

    fun addFavorteTrack(index: Int) {
        val trackPresentation = favoriteTracks.value?.get(index) ?: return
        favoriteTrackFocUseCase(track = trackPresentationToTrack(trackPresentation))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val track = _favoriteTracks.value?.get(index) ?: return@subscribe
                track.isFavorite = true
                _favoriteTracks.replace(index, track)
            }, {
                Logg.e("$it")
            }).also {
                addDisposable(dispose = it)
            }
    }

    fun deleteFavoriteTrack(index: Int) {
        val trackPresentation = favoriteTracks.value?.get(index) ?: return
        favoriteTrackNorUseCase(trackId = trackPresentation.trackId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val track = _favoriteTracks.value?.get(index) ?: return@subscribe
                track.isFavorite = false
                _favoriteTracks.replace(index, track)
            }, {
                Logg.e("$it")
            }).also {
                addDisposable(dispose = it)
            }
    }
}