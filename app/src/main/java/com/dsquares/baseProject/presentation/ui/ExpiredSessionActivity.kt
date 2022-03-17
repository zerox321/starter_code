package com.dsquares.baseProject.presentation.ui

import android.os.Bundle
import com.dsquares.baseProject.R
import com.dsquares.baseProject.databinding.ActivityExpiredSessionBinding
import com.dsquares.baseProject.presentation.core.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpiredSessionActivity :
    BaseActivity<ActivityExpiredSessionBinding>(contentLayoutId = R.layout.activity_expired_session) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding { }
    }

    override fun onBackPressed() {


    }

}
