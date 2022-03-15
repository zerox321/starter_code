package com.dsquares.baseProject.presentation.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dsquares.baseProject.R
import com.dsquares.baseProject.util.LangUtil.setLanguage


abstract class BaseActivity<T : ViewDataBinding> constructor(
    @LayoutRes private val contentLayoutId: Int
) : AppCompatActivity() {


    private val language: String by lazy { getString(R.string.default_language) }


    private lateinit var _binding: T
    protected val binding: T get() = _binding

    protected inline fun binding(block: T.() -> Unit): T = binding.apply(block)

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
        super.onCreate(savedInstanceState)
        setLanguage(language = language)

        _binding = DataBindingUtil.setContentView(this@BaseActivity, contentLayoutId)
        _binding.lifecycleOwner = this
        _binding.executePendingBindings()
    }

}
