package com.dsquares.baseProject.util


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.dsquares.baseProject.R
import com.dsquares.baseProject.util.ExceptionHandling.safeTaskHandler


object NavigationUtil {
    private const val tag = "NavigationUtil"
    fun NavController.navigateTo(
        id: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = defaultNavOptions,
        extras: Navigator.Extras? = null
    ) = safeTaskHandler { navigate(id, args, navOptions, extras) }


    fun NavController.clearNavigateStack(destinationId: Int? = null) =
        if (destinationId != null)
            safeTaskHandler { popBackStack(destinationId, false) }
        else
            safeTaskHandler { popBackStack() }


    fun <T> Fragment.setPreviousBackStackEntry(key: String, value: T) =
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, value)

    fun <T> Fragment.collectPreviousBackStackEntry(key: String, retryObserver: Observer<T>) =
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<T>(key)
            ?.observe(viewLifecycleOwner, retryObserver)

    private val defaultNavOptions by lazy {
        NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_to_left)
            .setPopEnterAnim(R.anim.enter_from_left)
            .setPopExitAnim(R.anim.exit_to_right)
            .build()
    }


}
