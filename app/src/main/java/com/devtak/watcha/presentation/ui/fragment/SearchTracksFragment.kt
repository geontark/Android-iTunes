package com.devtak.watcha.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.devtak.watcha.databinding.FragmentSearchTracksBinding
import com.devtak.watcha.presentation.search.SearchTrackAdapter
import com.devtak.watcha.presentation.viewmodel.SearchTracksVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchTracksFragment() : Fragment() {
    private lateinit var binding: FragmentSearchTracksBinding
    private val searchTracksVM by sharedViewModel<SearchTracksVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchTracksVM.favoriteUpdate()
        binding = FragmentSearchTracksBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SearchTracksFragment
            listSearchTracks.adapter = SearchTrackAdapter(searchTracksVM = searchTracksVM)
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