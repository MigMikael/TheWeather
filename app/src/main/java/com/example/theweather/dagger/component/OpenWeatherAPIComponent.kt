package com.example.theweather.dagger.component

import com.example.theweather.dagger.module.OpenWeatherAPIModule
import com.example.theweather.ui.presenter.MainPresenter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [OpenWeatherAPIModule::class])
public interface OpenWeatherAPIComponent {
    fun inject(presenter: MainPresenter);
}