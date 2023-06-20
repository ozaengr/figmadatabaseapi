package com.desire.figmadatabaseapi.retrofit

import android.media.Image

data class User(

    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)
