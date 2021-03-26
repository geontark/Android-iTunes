package com.devtak.watcha.presentation.ui.bindingadapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.devtak.watcha.R

@BindingAdapter("app:setImage", "app:setCorner", "app:setImageError")
fun ImageView.setImg(url: String?, corner: Int?, error: Drawable) {
    url?.let {
        val rounded = corner ?: 0
        val options = RequestOptions
            .bitmapTransform(RoundedCorners(rounded))
            .error(error)

        Glide.with(this)
            .load(it)
            .centerCrop()
            .apply(options)
            .placeholder(R.drawable.ic_question)
            .into(this)
    }
}