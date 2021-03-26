package com.devtak.watcha.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtak.watcha.databinding.TrackItemBinding
import com.devtak.watcha.presentation.model.TrackPresentation
import com.devtak.watcha.presentation.ui.listener.ItemClickForFavoriteStateListener
import com.devtak.watcha.presentation.viewmodel.FavoriteTracksVM
import kotlin.properties.Delegates

class FavoriteTracksAdapter(private val favoriteTracksVM: FavoriteTracksVM) :
    RecyclerView.Adapter<FavoriteTracksAdapter.ViewHolder>() {

    internal var collection: List<TrackPresentation> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(favoriteTracksVM = favoriteTracksVM, position = position , trackPresentation = collection[position])

    override fun getItemCount(): Int = collection.size

    class ViewHolder(private val binding: TrackItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteTracksVM: FavoriteTracksVM, position: Int, trackPresentation: TrackPresentation) {
            binding.apply {
                track = trackPresentation
                index = position
                favoriteItemClick = object : ItemClickForFavoriteStateListener {
                    override fun onFavoriteTrackItemClicked(
                        index: Int,
                        trackPresentation: TrackPresentation
                    ) {
                        if(trackPresentation.isFavorite) {
                            favoriteTracksVM.deleteFavoriteTrack(index)
                        } else {
                            favoriteTracksVM.addFavorteTrack(index)
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