package com.test.weatherdemo.injection.module

import com.test.weatherdemo.service.WeatherService
import com.test.weatherdemo.service.impl.WeatherServiceImpl
import dagger.Module
import dagger.Provides

@Module
class WeatherModule {

    @Provides
    fun providerWeatherRe(weatherService: WeatherServiceImpl): WeatherService {
        return weatherService
    }
}