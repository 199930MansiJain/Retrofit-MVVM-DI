package com.example.retrofitdependencinjection.core.utils

import android.widget.ImageView
import coil.ImageLoader
import coil.request.ImageRequest

fun ImageView.loadSvg(url: String, drawable: Int) {
    val imageLoader = ImageLoader.Builder(this.context)
        .build()
    val request = ImageRequest.Builder(this.context)
        .data(url)
        .crossfade(true)
        .target(this)
        .placeholder(drawable)
        .error(drawable)
        .memoryCacheKey(url) // Optional: set a custom cache key
        .build()
    imageLoader.enqueue(request)
}