package com.wl.aacdemo.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/**
 * Created by KY5680 on 04,09,2020
 */
class RepoBindings {

    companion object {

        @JvmStatic
        @BindingAdapter("visibleGone")
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImage(imageView: ImageView, url: String?) {
            val context = imageView.context
            Glide.with(context)
                .load(url)
                .into(imageView)
        }
    }
}