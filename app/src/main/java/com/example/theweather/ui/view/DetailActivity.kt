package com.example.theweather.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.theweather.R
import com.example.theweather.ui.ForecastItemViewModel
import com.example.theweather.ui.presenter.DetailPresenter
import kotlinx.android.synthetic.main.details_view.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity: AppCompatActivity(), DetailView {

    val presenter = DetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_view)
        presenter.values(intent)
    }

    override fun showInformation(forecast: ForecastItemViewModel) {
        detailCityName.text = forecast.cityName
        detailDegreeText.text = "${forecast.degreeDay} °C"
        detailMaximumDegreeText.text = "Maximum Degree: ${forecast.maximumDegree} °C"
        detailMinimumDegreeText.text = "Minimum Degree: ${forecast.minimumDegree} °C"
        detailPressureText.text = "${forecast.pressure} hPa"
        detailsHumidityText.text = "% ${forecast.humidity}"
        detailsDateText.text = getDate(forecast.date)
    }

    private fun getDate(date: Long): String {
        val timeFormatter = SimpleDateFormat("dd.MM.yyy")
        return timeFormatter.format(Date(date*1000L))
    }

}