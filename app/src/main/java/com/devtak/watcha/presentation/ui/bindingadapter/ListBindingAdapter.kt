package com.devtak.watcha.presentation.ui.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.presentation.model.TrackPresentation
import com.devtak.watcha.presentation.search.SearchTrackAdapter
import com.devtak.watcha.presentation.ui.adapter.FavoriteTracksAdapter

@BindingAdapter("app:setSearchTracks")
fun RecyclerView.setSearchTracks(tracks: List<TrackPresentation>?) {
    tracks?.let {
        (adapter as SearchTrackAdapter).collection = tracks.orEmpty()
    }
}

@BindingAdapter("app:setFavoriteTracks")
fun RecyclerView.setFavoriteTracks(tracks: List<TrackPresentation>?) {
    tracks?.let {
        (adapter as FavoriteTracksAdapter).collection = tracks.orEmpty()
    }
}