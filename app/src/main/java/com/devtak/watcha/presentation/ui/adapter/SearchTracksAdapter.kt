package com.devtak.watcha.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtak.watcha.databinding.TrackItemBinding
import com.devtak.watcha.presentation.model.TrackPresentation
import com.devtak.watcha.presentation.ui.listener.ItemClickForFavoriteStateListener
import com.devtak.watcha.presentation.viewmodel.SearchTracksVM
import kotlin.properties.Delegates

class SearchTrackAdapter(private val searchTracksVM: SearchTracksVM) :
    RecyclerView.Adapter<SearchTrackAdapter.ViewHolder>() {

    internal var collection: List<TrackPresentation> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(searchTrackVM = searchTracksVM, position = position, trackPresentation = collection[position])

    override fun getItemCount(): Int = collection.size

    class ViewHolder(private val binding: TrackItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(searchTrackVM: SearchTracksVM, position: Int, trackPresentation: TrackPresentation) {
            binding.apply {
                track = trackPresentation
                index = position
                favoriteItemClick = object : ItemClickForFavoriteStateListener {
                    override fun onFavoriteTrackItemClicked(
                        index: Int,
                        trackPresentation: TrackPresentation
                    ) {
                        if(trackPresentation.isFavorite) {
                            searchTrackVM.deleteFavoriteTrack(index)
                        } else {
                            searchTrackVM.addFavorteTrack(index)
                        }
                    }
                }
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TrackItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}