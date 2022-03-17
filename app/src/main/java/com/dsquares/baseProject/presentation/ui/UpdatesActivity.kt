package com.dsquares.baseProject.presentation.ui

import android.os.Bundle
import com.dsquares.baseProject.R
import com.dsquares.baseProject.databinding.ActivityUpdatesBinding
import com.dsquares.baseProject.presentation.core.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdatesActivity : BaseActivity<ActivityUpdatesBinding>(contentLayoutId = R.layout.activity_updates) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding { }
    }

}