package com.example.myapplication69

import android.graphics.Color
import androidx.annotation.DrawableRes

data class Feature(
    val title: String,
    @DrawableRes val icon: Int,
    val lightColor: Color,
    val darkColor: Color,
    val mediumColor: Color,
    )
