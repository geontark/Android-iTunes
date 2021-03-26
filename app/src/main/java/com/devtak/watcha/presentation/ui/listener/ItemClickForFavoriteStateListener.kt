package com.devtak.watcha.presentation.ui.listener

import com.devtak.watcha.presentation.model.TrackPresentation

interface ItemClickForFavoriteStateListener {
    fun onFavoriteTrackItemClicked(index: Int, trackPresentation: TrackPresentation)
}