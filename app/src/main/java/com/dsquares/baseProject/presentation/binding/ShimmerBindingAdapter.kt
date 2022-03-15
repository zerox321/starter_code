package com.dsquares.baseProject.presentation.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.facebook.shimmer.ShimmerFrameLayout


@BindingAdapter("loadShimmerView")
fun ShimmerFrameLayout.loadShimmerView(isLoading: Boolean) {
    visibility = if (isLoading) {
        startShimmer()
        View.VISIBLE
    } else {
        stopShimmer()
        View.GONE
    }
}
