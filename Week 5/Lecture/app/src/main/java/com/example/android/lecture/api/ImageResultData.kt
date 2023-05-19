package com.example.android.lecture.api

import com.example.android.lecture.model.CatBreedData
import com.squareup.moshi.Json
data class ImageResultData(
    @field:Json(name = "url") val imageUrl: String,
    val breeds: List<CatBreedData>
)