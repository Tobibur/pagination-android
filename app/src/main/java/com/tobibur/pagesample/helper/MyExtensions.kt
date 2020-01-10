package com.tobibur.pagesample.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.load(imgRes: Any?, context: Context) {
    Glide.with(context)
        .load(imgRes)
        .into(this)
}