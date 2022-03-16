package dsquares.com.core.repository

import dsquares.com.core.entities.remote.MenuItem


interface MenuRepo {
    suspend fun fetchMenuList(): List<MenuItem>
}