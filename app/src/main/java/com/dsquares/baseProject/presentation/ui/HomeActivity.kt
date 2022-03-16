package com.dsquares.baseProject.presentation.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dsquares.baseProject.R
import com.dsquares.baseProject.databinding.ActivityHomeBinding
import com.dsquares.baseProject.presentation.core.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(contentLayoutId = R.layout.activity_home) {
    private val navController by lazy { findNavController(R.id.nav_host_fragment_activity_home) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding { navView.setupWithNavController(navController) }

    }
}