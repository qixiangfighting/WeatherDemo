package com.test.weatherdemo.service.impl

import com.test.weatherdemo.data.bean.WeatherResponse
import com.test.weatherdemo.data.repository.WeatherRepository
import com.test.weatherdemo.service.WeatherService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * WeatherService between presenter and repository, means we clould easily switch the repositroy
 *
 */
class WeatherServiceImpl @Inject constructor() : WeatherService {
    @Inject
    lateinit var weatherRepository: WeatherRepository

    override fun getWeatherInfoByLocation(location: String): Observable<WeatherResponse> {
        return weatherRepository.getWeatherInfoByLocation(location)
    }

}