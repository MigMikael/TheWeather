package com.example.theweather.ui.view

import com.example.theweather.ui.ForecastItemViewModel

interface DetailView {
    fun showInformation(forecast: ForecastItemViewModel)
}