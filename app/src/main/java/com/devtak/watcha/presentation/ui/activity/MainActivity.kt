package com.devtak.watcha.presentation.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devtak.watcha.R
import com.devtak.watcha.core.log.Logg
import com.devtak.watcha.databinding.ActivityMainBinding
import com.devtak.watcha.presentation.viewmodel.FavoriteTracksVM
import com.devtak.watcha.presentation.viewmodel.SearchTracksVM
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
//    private val favoriteTracksVM: FavoriteTracksVM by inject()
//    private val searchTracksVM: SearchTracksVM by inject()
    private lateinit var binding: ActivityMainBinding
    private val favoriteTracksVM: FavoriteTracksVM by viewModel()
    private val searchTracksVM: SearchTracksVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBaseVM(favoriteTracksVM, searchTracksVM)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(
            binding.bottomNavigation,
            navController
        )
    }
}