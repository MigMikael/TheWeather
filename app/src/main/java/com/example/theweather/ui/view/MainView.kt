package com.example.theweather.ui.view

import com.example.theweather.ErrorTypes
import com.example.theweather.ui.ForecastItemViewModel

interface MainView {
    fun showSpinner()
    fun hideSpinner()
    fun updateForecast(forecasts: List<ForecastItemViewModel>)
    fun showErrorToast(errorType: ErrorTypes)
}