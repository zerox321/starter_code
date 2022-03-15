package com.dsquares.baseProject.presentation.binding


import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.imageLoader
import coil.request.ImageRequest
import com.facebook.shimmer.ShimmerFrameLayout


@BindingAdapter(value = ["loadImage", "loadShimmer"], requireAll = false)
fun ImageView.loadImage(
    imagePath: String?,
    shimmer: ShimmerFrameLayout? = null
) {
// Coil
    context.imageLoader.enqueue(request = ImageRequest.Builder(context)
        .data(imagePath.toString())
        .target(
            onStart = { shimmer?.loadShimmerView(isLoading = true) },
            onSuccess = { result ->
                this.setImageDrawable(result)
                shimmer?.loadShimmerView(isLoading = false)
            },
            onError = { shimmer?.loadShimmerView(isLoading = false) }
        ).build())
}




