package com.test.weatherdemo.presenter

import com.test.foundationlib.ext.execute
import com.test.foundationlib.presenter.BasePresenter
import com.test.foundationlib.rx.BaseSubscriber
import com.test.weatherdemo.data.bean.WeatherResponse
import com.test.weatherdemo.presenter.view.WeatherView
import com.test.weatherdemo.service.WeatherService
import javax.inject.Inject

/**
 * WeatherActivity hold the presenter and all the logic operation will be done by presenter
 *
 * WeatherActivity just do refresh UI  work
 *
 */
class WeatherPresenter @Inject constructor() : BasePresenter<WeatherView>() {

    @Inject
    lateinit var weatherService: WeatherService

    fun getWeatherInfoByLocation(location: String) {
        mView.showLoading()
        weatherService.getWeatherInfoByLocation(location).execute(object : BaseSubscriber<WeatherResponse>(mView) {
            override fun onNext(result: WeatherResponse) {
                mView.onWeatherInfoResult(result)
            }

        }, lifecycleProvider)
    }
}