package com.dsquares.baseProject.presentation.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dsquares.baseProject.R
import com.dsquares.baseProject.databinding.FragmentHomeBinding
import com.dsquares.baseProject.presentation.core.BaseFragment
import com.dsquares.baseProject.util.Toast.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeView : BaseFragment<FragmentHomeBinding>(contentLayoutId = R.layout.fragment_home),
    HomeViewActions {


    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            homeViewActions = this@HomeView
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            homeViewModel.menuListResponse.collect { result ->
                when (result) {
                    is HomeViewStatus.Error -> context?.showToast(message = result.errorBody ?: "unknown error")
                    is HomeViewStatus.Loading -> context?.showToast(message = "Loading")
                    is HomeViewStatus.Success -> context?.showToast(message = result.data.toString())
                    is HomeViewStatus.EMPTY -> context?.showToast(message = "Empty")
                }
            }
        }
    }

    override fun fetchMenuList() {
        homeViewModel.getMenuList()
    }


}