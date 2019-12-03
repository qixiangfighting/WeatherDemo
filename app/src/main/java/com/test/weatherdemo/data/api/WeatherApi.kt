package com.test.weatherdemo.data.api

import com.test.weatherdemo.data.bean.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("{location}")
    fun getWeatherInfoByLocation(
        @Path("location") location: String
    ): Observable<WeatherResponse>
}