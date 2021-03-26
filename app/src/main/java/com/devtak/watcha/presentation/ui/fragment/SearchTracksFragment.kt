package com.devtak.watcha.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.devtak.watcha.databinding.FragmentSearchTracksBinding
import com.devtak.watcha.presentation.search.SearchTrackAdapter
import com.devtak.watcha.presentation.ui.activity.MainActivity

class SearchTracksFragment() : Fragment() {
    private lateinit var binding: FragmentSearchTracksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val searchTracksVM = (activity as MainActivity).searchTracksVM
        searchTracksVM.favoriteUpdate()
        binding = FragmentSearchTracksBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SearchTracksFragment
            listSearchTracks.adapter = SearchTrackAdapter(searchTracksVM)
             vm = searchTracksVM
        }

        binding.swipeLayout.setOnRefreshListener {
            searchTracksVM.searchTrack()
        }

        searchTracksVM.searchRefreshDoneEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                binding.swipeLayout.isRefreshing = false
            }
        })
        return binding.root
    }
}