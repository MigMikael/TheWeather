package com.example.theweather.dagger.module

import com.example.theweather.api.OpenWeatherAPI
import com.example.theweather.api.OpenWeatherInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [GSONModule::class])
class OpenWeatherAPIModule {

    @Provides
    @Singleton
    fun provideApi(gson : Gson): OpenWeatherAPI {

        val apiClient = OkHttpClient.Builder().addInterceptor(OpenWeatherInterceptor()).build()

        return Retrofit.Builder().apply {
            baseUrl(OpenWeatherAPI.BASE_URL)
            addConverterFactory(GsonConverterFactory.create(gson))
            client(apiClient)
        }.build().create(OpenWeatherAPI::class.java)
    }
}