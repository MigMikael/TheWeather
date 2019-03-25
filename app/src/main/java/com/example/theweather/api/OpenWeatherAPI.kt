package com.example.theweather.api


import com.example.theweather.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {

    @GET("forecast/daily")
    //fun dailyForecast(@Query("q") cityName: String, @Query("cnt") dayCount: Int) : Call<WeatherResponse>
    fun dailyForecast(@Query("q") cityName: String) : Call<WeatherResponse>

    companion object {
        //val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        val BASE_URL = "https://samples.openweathermap.org/data/2.5/"
    }
}