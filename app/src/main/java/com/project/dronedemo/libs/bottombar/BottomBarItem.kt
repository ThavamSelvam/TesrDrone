package com.project.dronedemo.libs.bottombar

import android.graphics.RectF
import android.graphics.drawable.Drawable

data class BottomBarItem(
    val text: CharSequence,
    val icon: Drawable,
    var rect: RectF = RectF()
)