package com.example.theweather.data

import com.google.gson.annotations.SerializedName

data class Temperature(@SerializedName("day") var dayTemperature: Double,
                       @SerializedName("night") var nightTemperature: Double,
                       @SerializedName("min") var minTemperature: Double,
                       @SerializedName("max") var maxTemperature: Double)