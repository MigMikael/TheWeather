package com.example.theweather.ui.presenter

import android.content.Intent
import com.example.theweather.ui.ForecastItemViewModel
import com.example.theweather.ui.view.DetailView

class DetailPresenter(val view : DetailView) {

    fun values(intent: Intent?) {
        intent?.extras?.let {
            val item : ForecastItemViewModel = it["extra"] as ForecastItemViewModel
            view.showInformation(item)
        }
    }
}