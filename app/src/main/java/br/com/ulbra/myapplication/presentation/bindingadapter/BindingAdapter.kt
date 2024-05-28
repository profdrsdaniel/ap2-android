package br.com.ulbra.myapplication.presentation.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("loadImg")
    @JvmStatic
    fun ImageView.loadImg(url: String) {
        Glide.with(context)
            .load(url)
            .fitCenter()
            .into(this)
    }
}