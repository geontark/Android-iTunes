package com.devtak.watcha.presentation.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devtak.watcha.R
import com.devtak.watcha.databinding.ActivityMainBinding
import com.devtak.watcha.presentation.viewmodel.FavoriteTracksVM
import com.devtak.watcha.presentation.viewmodel.SearchTracksVM
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    val favoriteTracksVM: FavoriteTracksVM by inject()
    val searchTracksVM: SearchTracksVM by inject()
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        searchTracksVM.toastEvent.observe(this, { event ->
            event.getContentIfNotHandled()?.let {
                showToast(it, false)
            }
        })

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