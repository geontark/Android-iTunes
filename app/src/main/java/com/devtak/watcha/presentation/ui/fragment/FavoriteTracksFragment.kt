package com.devtak.watcha.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devtak.watcha.databinding.FragmentFavoriteTracksBinding
import com.devtak.watcha.presentation.ui.activity.MainActivity
import com.devtak.watcha.presentation.ui.adapter.FavoriteTracksAdapter

class FavoriteTracksFragment() : Fragment() {
    private lateinit var binding: FragmentFavoriteTracksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).favoriteTracksVM.getAllFavoriteTracks()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTracksBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FavoriteTracksFragment
            listFavoriteTracks.adapter = FavoriteTracksAdapter((activity as MainActivity).favoriteTracksVM)
            vm = (activity as MainActivity).favoriteTracksVM
        }
        return binding.root
    }
}