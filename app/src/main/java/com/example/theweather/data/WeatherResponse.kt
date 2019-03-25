package com.example.theweather.data

import com.google.gson.annotations.SerializedName

data class WeatherResponse (@SerializedName("city") var city: City,
                            @SerializedName("list") var forecast :List<ForecastDetail>)