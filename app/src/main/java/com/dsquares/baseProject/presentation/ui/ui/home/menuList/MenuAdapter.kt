package com.dsquares.baseProject.presentation.ui.ui.home.menuList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dsquares.baseProject.databinding.MenuItemRowBinding
import dsquares.com.core.entities.remote.MenuItem

class MenuAdapter : ListAdapter<MenuItem, MenuAdapterViewHolder>(MenuItemDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapterViewHolder =
        MenuAdapterViewHolder(
            binding = MenuItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MenuAdapterViewHolder, position: Int) =
        holder.bind(item = getItem(position))
}