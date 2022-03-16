package com.dsquares.baseProject.presentation.ui.ui.home.menuList

import androidx.recyclerview.widget.DiffUtil
import dsquares.com.core.entities.remote.MenuItem


class MenuItemDiffCallBack : DiffUtil.ItemCallback<MenuItem>() {
    override fun areItemsTheSame(old: MenuItem, new: MenuItem): Boolean =
        old.id == new.id

    override fun areContentsTheSame(old: MenuItem, new: MenuItem): Boolean =
        old == new
}