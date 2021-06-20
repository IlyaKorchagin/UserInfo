package com.korchagin.userinfo.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.korchagin.userinfo.R

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
   if(!url.isNullOrEmpty()) {
       Glide.with(view.context)
           .load(url)
           .placeholder(R.drawable.user)
           .error(R.drawable.user)
           .fallback(R.drawable.user)
           .into(view)
   }
   else
   { Glide.with(view.context)
       .load("https://yt3.ggpht.com/a/AATXAJz5PteRMVpzYluhCr0s0vcih8yOu_87oYJcrpfhtQ=s900-c-k-c0xffffffff-no-rj-mo")
       .into(view)}

}