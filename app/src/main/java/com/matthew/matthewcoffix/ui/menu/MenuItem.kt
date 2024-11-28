package com.matthew.matthewcoffix.ui.menu

import androidx.annotation.DrawableRes

data class MenuItem(
    val id: Int,
    val cost: Float,
    val text: String,
    val description: String?,
    @DrawableRes val image: Int
)
