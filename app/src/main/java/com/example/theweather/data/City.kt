package com.example.theweather.data

import com.google.gson.annotations.SerializedName

data class City(@SerializedName("name") var cityName: String,
                @SerializedName("country") var countru: String)