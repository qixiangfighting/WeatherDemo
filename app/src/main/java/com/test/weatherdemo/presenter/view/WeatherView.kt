package com.test.weatherdemo.presenter.view

import com.test.foundationlib.presenter.view.BaseView
import com.test.weatherdemo.data.bean.WeatherResponse

interface WeatherView:BaseView {
    fun onWeatherInfoResult(result: WeatherResponse)
}