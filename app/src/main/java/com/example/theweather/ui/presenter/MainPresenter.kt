package com.example.theweather.ui.presenter

import com.example.theweather.BuildConfig
import com.example.theweather.ErrorTypes
import com.example.theweather.api.OpenWeatherAPI
import com.example.theweather.data.ForecastDetail
import com.example.theweather.data.WeatherResponse
import com.example.theweather.ui.ForecastItemViewModel
import com.example.theweather.ui.view.MainView
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainView) {
    @Inject
    lateinit var api: OpenWeatherAPI

    fun getForecastForSevenDays(cityName: String) {
        if (BuildConfig.OPEN_WEATHER_API_KEY == "abcdefg") {
            view.showErrorToast(ErrorTypes.MISSING_API_KEY)
            return
        }
        view.showSpinner()
        //api.dailyForecast(cityName, 7)
        api.dailyForecast(cityName).enqueue(object : Callback<WeatherResponse> {

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                response.body()?.let {
                    createListForView(it, cityName)
                    view.hideSpinner()
                } ?: view.showErrorToast(ErrorTypes.NO_RESULT_FOUND)
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                view.showErrorToast(ErrorTypes.CALL_ERROR)
                t.printStackTrace()
            }
        })
    }

    private fun createListForView(weatherResponse: WeatherResponse, cityName: String) {
        val forecasts = mutableListOf<ForecastItemViewModel>()
        for (forecastDetail: ForecastDetail in weatherResponse.forecast) {
            val dayTemp = forecastDetail.temperature.dayTemperature
            val forecastItem = ForecastItemViewModel(degreeDay = dayTemp.toString(),
                date = forecastDetail.date,
                icon = forecastDetail.description[0].icon,
                description = forecastDetail.description[0].description,
                humidity = forecastDetail.humidity.toString(),
                pressure = forecastDetail.pressure.toString(),
                minimumDegree = forecastDetail.temperature.minTemperature.toString(),
                maximumDegree = forecastDetail.temperature.maxTemperature.toString(),
                cityName = cityName)
            forecasts.add(forecastItem)
        }
        view.updateForecast(forecasts)
    }
}