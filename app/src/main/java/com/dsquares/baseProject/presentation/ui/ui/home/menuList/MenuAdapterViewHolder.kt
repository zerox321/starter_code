package com.dsquares.baseProject.presentation.ui.ui.home.menuList

import androidx.recyclerview.widget.RecyclerView
import com.dsquares.baseProject.databinding.MenuItemRowBinding
import dsquares.com.core.entities.remote.MenuItem

class MenuAdapterViewHolder(
    private val binding: MenuItemRowBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MenuItem) {
        binding.menuItem = item
        binding.executePendingBindings()
    }
}