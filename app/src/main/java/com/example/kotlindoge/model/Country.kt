package com.example.kotlindoge.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * @JsonClass(generateAdapter = true)
 * Moshi uses the code above to help parse into the data class you created
 *
 * @field:Json(name = "")
 * Moshi uses the code above as the key for the incoming json property
 * use this if the variable name will be differnt from the json key name
 */

@Parcelize // DO NOT FORGET TO ADD id 'kotlin-parcelize' to the plugins in your build.gradle(module)
@JsonClass(generateAdapter = true)
data class Country(
    @field:Json(name = "city_name")
    val cityName: String,
    val coordinates: List<Float>
) : Parcelable
