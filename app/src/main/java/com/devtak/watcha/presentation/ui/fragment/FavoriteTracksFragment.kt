package com.devtak.watcha.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devtak.watcha.databinding.FragmentFavoriteTracksBinding
import com.devtak.watcha.presentation.ui.adapter.FavoriteTracksAdapter
import com.devtak.watcha.presentation.viewmodel.FavoriteTracksVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoriteTracksFragment() : Fragment() {
    private lateinit var binding: FragmentFavoriteTracksBinding
    private val favoriteTracksVM by sharedViewModel<FavoriteTracksVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteTracksVM.getAllFavoriteTracks()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTracksBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FavoriteTracksFragment
            listFavoriteTracks.adapter = FavoriteTracksAdapter(favoriteTracksVM = favoriteTracksVM)
            vm = favoriteTracksVM
        }
        return binding.root
    }
}