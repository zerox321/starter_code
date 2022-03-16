package dsquares.com.core.usecase

import dsquares.com.core.repository.MenuRepo


class GetAllMenus(private val menuRepo: MenuRepo) {
    suspend operator fun invoke() = menuRepo.fetchMenuList()
}