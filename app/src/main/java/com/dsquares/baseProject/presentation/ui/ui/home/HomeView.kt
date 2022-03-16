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
import com.dsquares.baseProject.presentation.ui.ui.home.menuList.MenuAdapter
import com.dsquares.baseProject.presentation.util.Toast.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeView : BaseFragment<FragmentHomeBinding>(contentLayoutId = R.layout.fragment_home),
    HomeViewActions {


    private val homeViewModel by viewModels<HomeViewModel>()
    private val menuAdapter by lazy { MenuAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            homeViewActions = this@HomeView
            menuAdapter = this@HomeView.menuAdapter
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            homeViewModel.menuListResponse.collect { result ->
                if (result is HomeViewStatus.Success) menuAdapter.submitList(result.data)
                else if (result is HomeViewStatus.Error) context?.showToast(
                    message = result.errorBody ?: "unknown error"
                )
                binding.isLoading = result == HomeViewStatus.Loading
                binding.isEmpty = result == HomeViewStatus.EMPTY
            }
        }
    }

    override fun fetchMenuList() {
        homeViewModel.getMenuList()
    }


}