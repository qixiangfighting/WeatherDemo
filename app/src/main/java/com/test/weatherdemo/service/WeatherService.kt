package com.test.weatherdemo.service

import com.test.weatherdemo.data.bean.WeatherResponse
import io.reactivex.Observable

interface WeatherService {
    fun getWeatherInfoByLocation(location: String): Observable<WeatherResponse>
}