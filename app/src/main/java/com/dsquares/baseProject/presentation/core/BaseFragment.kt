package com.dsquares.baseProject.presentation.core


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dsquares.baseProject.presentation.util.KeyboardUtil.hideKeyboard
import com.dsquares.baseProject.presentation.util.NavigationUtil.clearNavigateStack


abstract class BaseFragment<T : ViewDataBinding> constructor(
    @LayoutRes private val contentLayoutId: Int
) : Fragment() {

    /** This interface is generated during compilation to contain getters for all used instance `BindingAdapters`. */
    private var bindingComponent: DataBindingComponent? = DataBindingUtil.getDefaultComponent()

    /** A backing field for providing an immutable [binding] property.  */
    private lateinit var _binding: T
    protected val TAG: String = this.javaClass.name

    /**
     * A data-binding property will be initialized in [onCreateView].
     * And provide the inflated view which depends on [contentLayoutId].
     */
    protected val binding: T get() = _binding

    /**
     * An executable inline binding function that receives a binding receiver in lambda.
     *
     * @param block A lambda block will be executed with the binding receiver.
     * @return T A generic class that extends [ViewDataBinding] and generated by DataBinding on compile time.
     */
    protected inline fun binding(block: T.() -> Unit): T = binding.apply(block)

    /**
     * Ensures the [binding] property should be executed and provide the inflated view which depends on [contentLayoutId].
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, contentLayoutId, container, false, bindingComponent)
        _binding.lifecycleOwner = viewLifecycleOwner
        _binding.executePendingBindings()
        return _binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideKeyboard()
    }

    fun onBack(destinationId: Int? = null) = findNavController().clearNavigateStack(destinationId)
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        hideKeyboard()
    }

    private fun hideKeyboard() {
        activity?.currentFocus?.hideKeyboard()
    }


}




