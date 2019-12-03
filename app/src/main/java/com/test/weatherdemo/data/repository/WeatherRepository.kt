package com.test.weatherdemo.data.repository

import com.test.foundationlib.data.net.RetrofitFactory
import com.test.weatherdemo.data.api.WeatherApi
import com.test.weatherdemo.data.bean.WeatherResponse
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepository @Inject constructor() {

    fun getWeatherInfoByLocation(location: String): Observable<WeatherResponse> {
        return RetrofitFactory.instance.create(WeatherApi::class.java).getWeatherInfoByLocation(location)
    }

}